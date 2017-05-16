package action;

import entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import security.RoleSign;
import service.RoleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/13 14:50
 */
@Controller
@RequestMapping(value = "/role")
public class RoleAction {
    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "/addUi")
    public String addUi(Model model){
        Map<Integer, String> ballMap = new HashMap<Integer, String>();
        model.addAttribute("RoleSign", RoleSign.Rolesigin);
        return "admin-role-add";
    }

    @RequestMapping(value = "/add")
    public String add(Role role){
        roleService.insert(role);
        return "index";
    }

    @RequestMapping(value = "/roleList")
    public String roleList(Model model){
        List<Role> roleList = roleService.seletAllRole();
        model.addAttribute("roleList",roleList);
        return "admin-role";
    }
}
