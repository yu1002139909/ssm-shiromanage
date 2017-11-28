package action;

import entity.Course;
import entity.Grade;
import entity.Major;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.CourseService;
import service.GradeService;
import service.MajorServlice;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/8 18:18
 */
@Controller
public class GradeAction {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private MajorServlice majorServlice;
    @Autowired
    UserService userService;

    @RequestMapping("grade/add")
    public String add(Grade grade ,@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //获取webapp的物理路劲
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path="";
        System.out.println("文件上传");
        if(!file.isEmpty()){
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType=file.getContentType();
            //获得文件后缀名称
            System.out.println(contentType);
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path="/static/images/"+uuid+".jpg";
            grade.setPhoto(path);
            file.transferTo(new File(pathRoot+path));
        }
        gradeService.add(grade);
        return "index";
    }


    @RequestMapping("grade/addUi")
    public  String addUi(Model model, String course_id,HttpServletRequest request){
        System.out.println(course_id);
        List<Course> courseList = courseService.getAll();
        User userInfo = (User)request.getSession().getAttribute("userInfo");
        //通过UserId查询所属学院
        User user = userService.selectByPrimaryKey(userInfo.getId());
        if(true){
            model.addAttribute("courseList",courseList);
            List<Major> majorList = majorServlice.findbymajorByCouserId(course_id);
            model.addAttribute("majorList",majorList);
            return "grade-add";
        }
        return "grade-add";
    }
    @RequestMapping("grade/getMajor")
    public @ResponseBody Map<String,Object> getMajor(String course_id){
        List<Major> majors = majorServlice.findbymajorByCouserId(course_id);
        Map<String,Object> jsonMap = new HashMap<String, Object>();
        List list = null;
        if(null != majors && majors.size()>0){
            list = new ArrayList();
            for(Major major : majors){
                Map<String,String> taskMap=new HashMap<String,String>();
                taskMap.put("major_id", major.getMajor_id());
                taskMap.put("major_name", major.getMajor_name());
                list.add(taskMap);
            }
        }
        jsonMap.put("tasks", list);
        return jsonMap;
    }
    @RequestMapping(value = "grade/list")
    public String  list(Model model,String majorid){
        System.out.println(majorid);
        List<Grade> gradeList = gradeService.findbyGradeMapperByMajorId(majorid);
        //根据专业查询学院Id
        Major major = majorServlice.findById(majorid);
        String course_id = major.getMcourse_id();
        System.out.println(course_id);
        model.addAttribute("course_id",course_id);
        model.addAttribute("gradeList",gradeList);
        return"gradelist";
    }
    @RequestMapping(value = "grade/updateUi")
    public String updateUi(Model model,String grade_id){
        List<Course> courseList = courseService.getAll();
        Grade grade = gradeService.findById(grade_id);
        model.addAttribute("grade",grade);
        model.addAttribute("courseList",courseList);
        return "grade-update";
    }
    @RequestMapping(value = "grade/update")
    public String update(Grade grade ,@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //获取webapp的物理路劲
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path="";
        System.out.println("文件上传");
        if(!file.isEmpty()){
            String uuid = UUID.randomUUID().toString().replaceAll("-","");    String contentType=file.getContentType();
            //获得文件后缀名称
            System.out.println(contentType);
            String imageName=contentType.substring(contentType.indexOf("/")+1);
            path="/static/images/"+uuid+".jpg";
            grade.setPhoto(path);
            file.transferTo(new File(pathRoot+path));
        }
        gradeService.update(grade);
        return "index";
    }
    @RequestMapping(value = "grade/delete",method = RequestMethod.POST)
    public String   delete(String id){
        System.out.println("删除成功");
        gradeService.delete(id);
        return"index";
    }
}
