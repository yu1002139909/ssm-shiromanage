package action;

import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.RoleService;
import service.UserService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/15 15:35
 */
@Controller
@RequestMapping( value = "/user")
public class UserAction {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @RequestMapping(value = "/addUi")
    public String addUi(Model model){
        List<Role> roleList = roleService.seletAllRole();
        model.addAttribute("roleList",roleList);
        return "user/admin-add";
    }
    @RequestMapping(value = "/userlist")
    public String list(Model model){
        List<User> userList = userService.selectAll();
        model.addAttribute("userList",userList);
        return "admin-list";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(User user){
        userService.insert(user);
        return "index";
    }
}
