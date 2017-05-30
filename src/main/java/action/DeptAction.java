package action;

import entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.DeptService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/29 22:03
 */
@Controller
public class DeptAction {
    @Autowired
    DeptService deptService;
    @RequestMapping("/deptList")
    public String list(Model model){
        List<Dept> deptList = deptService.getall();
        model.addAttribute("deptList",deptList);
        return "";
    }
}
