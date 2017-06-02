package action;

import entity.Course;
import entity.Grade;
import entity.Major;
import entity.Student;
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
import service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/2 10:58
 */
@Controller
public class StudentAction {
    //注入studentService
    @Autowired
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    private CourseService courseService;

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    private GradeService gradeService;

    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @Autowired
    private MajorServlice majorServlice;
    public void setMajorServlice(MajorServlice majorServlice) {
        this.majorServlice = majorServlice;
    }
    //获取增加学生页面
    @RequestMapping(value = "student/addUi")
    public String addUi(Model model) {
        List<Course> courseList = courseService.getAll();
        model.addAttribute("courseList", courseList);
        return "student-add";
    }
    //增加学生的具体操作
    @RequestMapping(value = "student/add",method = RequestMethod.POST)
    public String add(Student student, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
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
            student.setPhoto(path);
            file.transferTo(new File(pathRoot+path));
        }
        studentService.add(student);
        return "index";
    }
    //显示学生列表首页
    @RequestMapping(value = "student/stulist")
    public String stulist(Model model,String grade_id ){
        List<Student> studentList = studentService.findByGradeId(grade_id);
        model.addAttribute("studentList",studentList);
        return "studentlist";
    }
    //删除学生
    @RequestMapping(value = "student/delete")
    public String delete(String id){
        studentService.delete(id);
        return "index";
    }

    //修改学生界面
    @RequestMapping(value = "student/updateUi")
    public String updateUi(Model model,String id){
        List<Course> courseList = courseService.getAll();
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        model.addAttribute("courseList",courseList);
        return "student-update";
    }
    //修改学生的具体操作
    @RequestMapping(value = "student/update",method = RequestMethod.POST)
    public String update(Student student, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
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
            student.setPhoto(path);
            file.transferTo(new File(pathRoot+path));
        }
        studentService.update(student);
        return "index";
    }
    @RequestMapping("student/getMajor")
    public
    @ResponseBody
    Map<String, Object> getMajor(String major_id) {
        List<Major> majors = majorServlice.findbymajorByCouserId(major_id);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        List list = null;
        if (null != majors && majors.size() > 0) {
            list = new ArrayList();
            for (Major major : majors) {
                Map<String, String> taskMap = new HashMap<String, String>();
                taskMap.put("major_id", major.getMajor_id());
                taskMap.put("major_name", major.getMajor_name());
                list.add(taskMap);
                System.out.println(list.size());
            }
        }
        jsonMap.put("tasks", list);
        return jsonMap;
    }
    @RequestMapping("student/getGrade")
    public
    @ResponseBody
    Map<String, Object> getGrade(String grade_id) {
        List<Grade> gradeList = gradeService.findbyGradeMapperByMajorId(grade_id);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        List list = null;
        if (null != gradeList && gradeList.size() > 0) {
            list = new ArrayList();
            for (Grade grade : gradeList) {
                Map<String, String> taskMap = new HashMap<String, String>();
                taskMap.put("grade_id", grade.getGrade_id());
                taskMap.put("grade_name", grade.getGrade_name());
                list.add(taskMap);
                System.out.println(list.size());
            }
        }
        jsonMap.put("gradeList", list);
        return jsonMap;
    }
}

