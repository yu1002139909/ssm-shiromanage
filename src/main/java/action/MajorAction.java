package action;

import entity.Course;
import entity.Major;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CourseService;
import service.MajorServlice;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/4 21:13
 */
@Controller
public class MajorAction {
    @Autowired
    private CourseService courseService;
    @Autowired
    private MajorServlice majorServlice;
    @Autowired
    UserService userService;
    //增加专业,获取学院id判断当前登陆用户所属角色是否和学院相匹配
    @RequestMapping("/major/addUi")
    public String add(Model model,String course_id,HttpServletRequest request){
        //从sesison获取User实体
        User userInfo = (User)request.getSession().getAttribute("userInfo");
        //通过UserId查询所属学院
        User user = userService.selectByPrimaryKey(userInfo.getId());

        if(user.getCourse().getCourse_id().equals(course_id)){
            List<Course> courseList = courseService.getAll();
            model.addAttribute("courseList",courseList);
            return "major-add";
        }
        return "401";
    }

    @RequestMapping("/major/add")
    public String addMajor(Major major, HttpServletRequest request){
        User userInfo = (User)request.getSession().getAttribute("userInfo");
        String username = userInfo.getUsername();
        majorServlice.add(major);
        return "index";
    }

    @RequestMapping("major/list")
    public String  majorlist(Model model,String course_id){
        List<Major> majorList = majorServlice.findbymajorByCouserId(course_id);
        model.addAttribute("course_id",course_id);
        model.addAttribute("majorList",majorList);
        return "majorlist";
    }

    @RequestMapping("/major/updateUi")
    public String updateUi(String id,Model model){
        Major major = majorServlice.findById(id);
        List<Course> courseList = courseService.getAll();
        model.addAttribute("major",major);
        model.addAttribute("courselist",courseList);
        return "major-update";
    }

    @RequestMapping("/major/update")
    public String update(Major major){
        majorServlice.update(major);
        System.out.println(major.getMajor_name());
        return "index";
    }

    @RequestMapping("/major/delete")
    public String delete(String id){
        System.out.println("删除成功");
        majorServlice.delete(id);
        return "index";
    }
}
