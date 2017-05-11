package action;

import entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CourseService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/3 15:39
 */
@Controller
public class CourseAction {
    @Autowired
    private CourseService courseService;
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("addCourse.action")
    public String add(Course course){
                 courseService.add(course);
        return"forward:/courselist.action";
  }
    @RequestMapping("courselist.action")
    public String list(Model model){
        List<Course> all = courseService.getAll();
        int num  = all.size();
        model.addAttribute("all",all);
        model.addAttribute("num",num);
        return "courselist";
    }
    //删除学院操作
    @RequestMapping("delete.action")
    public String delete(String id){
        System.out.println(id);
        courseService.delete(id);
        System.out.println("删除成功");
        return"forward:/courselist.action";
    }
    //修改学院信息Ui
    @RequestMapping("/course/updateUi")
    public String updateUi(Model model,String id){
        System.out.println(id);
        Course course = courseService.findById(id);
        model.addAttribute("course",course);
            return "course-update";
    }
    //修改学院信息的具体操作
    @RequestMapping("/course/update")
    public String update(Course course){
        System.out.println(course.getCourse_id()+"名称"+course.getCourse_name());
        courseService.update(course);
        return"forward:/courselist.action";
    }
}
