import entity.User;
import mapper.UserMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import util.MD5;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/11 19:45
 */

public class UserTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    // 从spring容器中获取mapper代理对象
    UserService userService = context.getBean(UserService.class);
    UserMapper userMapper = context.getBean(UserMapper.class);

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
        User user1 = userService.authentication(user);
        System.out.println(user1);
    }
    @Test
    public  void getall(){
        User user = userService.selectByUsername("admin");
        System.out.println(user.getId());
    }
}
