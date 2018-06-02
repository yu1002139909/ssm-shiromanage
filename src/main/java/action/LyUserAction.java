package action;

import entity.LyUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.LyUserService;
import util.OrderUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/5 21:11
 */
@Controller
public class LyUserAction {
    @Autowired
    LyUserService userService;
    @RequestMapping(value = "/user/login")
    public String login(LyUser user, BindingResult result, Model model, HttpServletRequest request) {
        try {
            Subject subject = SecurityUtils.getSubject();
            // 已登陆则 跳到首页
            if (subject.isAuthenticated()) {
                return "indexui";
            }
            if (result.hasErrors()) {
                model.addAttribute("error", "参数错误！");
                return "login";
            }
            // 身份验证
            subject.login(new UsernamePasswordToken(user.getUserName(),user.getPassword()));
            // 验证成功在Session中保存用户信息
            final LyUser authUserInfo = userService.findByUserName(user.getUserName());
            request.getSession().setAttribute("userInfo", authUserInfo);
        } catch (AuthenticationException e) {
            // 身份验证失败
            model.addAttribute("error", "用户名或密码错误 ！");
            return "login";
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("userInfo");
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }


    @RequestMapping(value = "userList",method = RequestMethod.GET)
    public String userList(Model model){
        List<LyUser> lyUsers = userService.getAll();
        model.addAttribute("userList",lyUsers);
        return "member-list";
    }

    /**
     * 用户注册
     * @param lyUser
     * @return
     */
    @RequestMapping(value = "useradd",method = RequestMethod.POST)
    public ModelAndView add(LyUser lyUser){
        LyUser lyUser1 = userService.findByUserName(lyUser.getUserName());
        if(lyUser1!=null){
            throw  new SecurityException("用户存在");
        }
        lyUser.setId(new BigInteger(OrderUtil.getOrderNumber("10")));
        lyUser.setDate(new Date(System.currentTimeMillis()));
        lyUser.setState("正常");
        userService.add(lyUser);
        ModelAndView mv = new ModelAndView("redirect:/404.jsp");
        return mv;
    }
    @RequestMapping(value = "updateState",method = RequestMethod.POST)
    @ResponseBody
    public String updateState(LyUser user){
        String state = user.getState();
        if(state.equals("1")){
            user.setState("失效");
        }
        else if (state.equals("2")){
            user.setState("正常");
        }
        userService.updateUserState(user);
        return "success";
    }
    @RequestMapping(value = "addUserRole",method = RequestMethod.GET)
    @ResponseBody
    public String addUserRole(BigInteger id){
        LyUser lyUser = new LyUser();
        lyUser.setRole("admin");
        lyUser.setId(id);
        userService.addUserRole(lyUser);
        return "success";
    }

    @RequestMapping(value = "deleteUser",method = RequestMethod.GET)
    @ResponseBody
    public String deleteUser(BigInteger id){
        userService.delete(id);
        return "success";
    }

    @RequestMapping(value = "updateUserUi",method = RequestMethod.GET)
    public String update(BigInteger id,Model model){

        LyUser user = userService.findById(id);
        model.addAttribute("user",user);
        return "member-update";
    }

    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public String updateUser(LyUser user,Model model){
        userService.update(user);
        return "member-list";
    }

    @RequestMapping(value = "adminList" ,method = RequestMethod.GET)
    public String adminList(Model model){
        List<LyUser> lyUsers = userService.AdminList();
        model.addAttribute("userList",lyUsers);
        return "member-list";
    }
}
