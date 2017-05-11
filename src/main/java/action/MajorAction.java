package action;

import entity.Course;
import entity.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CourseService;
import service.MajorServlice;

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

    public void setMajorServlice(MajorServlice majorServlice) {
        this.majorServlice = majorServlice;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/major/addUi")
    public String add(Model model){
        List<Course> courseList = courseService.getAll();
        model.addAttribute("courseList",courseList);
        return "major-add";
       }
    @RequestMapping("/major/add")
    public String addMajor(Major major){
        majorServlice.add(major);
        return "index";
    }
    @RequestMapping("major/list")
    public String  majorlist(Model model){
        List<Major> majorList = majorServlice.getAll();
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
