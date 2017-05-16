import entity.User;
import mapper.UserMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.RoleService;
import service.UserService;
import util.MD5;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/11 19:45
 */

public class UserTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    // 从spring容器中获取mapper代理对象
    UserService userService = context.getBean(UserService.class);
    UserMapper userMapper = context.getBean(UserMapper.class);
    RoleService roleService = context.getBean(RoleService.class);

    @Test
    public void  findById(){
        String str = "111";
        Md5Hash md5Hash = new Md5Hash(str);
        String strmd5 = md5Hash.toString();
        String md5ofStr = new MD5().getMD5ofStr(strmd5);
        System.out.println(md5ofStr);
    }
    @Test
    public  void add(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.insert(user);
    }

    @Test
    public  void getall(){
        List<User> roles = userService.selectAll();
        System.out.println(roles.size());
    }

    @Test
    public void select(){
        User user = userService.selectByUsername("admin");
        System.out.println(user);
    }
}
