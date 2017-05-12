package action;

import entity.User;
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
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/12 9:20
 */
@Controller
public class UserAction {
    /**@author yu
     * @version 1.0
     * @Date 2017/5/12
     * 注入service
     */
    @Autowired
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/login")
    public String login(User user, BindingResult result, Model model, HttpServletRequest request) {
        try {
            Subject subject = SecurityUtils.getSubject();
            // 已登陆则 跳到首页
            if (subject.isAuthenticated()) {
                return "redirect:/";
            }
            if (result.hasErrors()) {
                model.addAttribute("error", "参数错误！");
                return "login";
            }
            // 身份验证
            subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
            // 验证成功在Session中保存用户信息
            final User authUserInfo = userService.selectByUsername(user.getUsername());
            List<User> userList = userService.selectAll();
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
    @RequestMapping(value = "/user/userlist")
    public String list(Model model){
        List<User> userList = userService.selectAll();
        model.addAttribute("userList",userList);
        return "admin-list";
    }
}
