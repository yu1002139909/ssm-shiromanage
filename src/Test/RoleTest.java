import entity.Role;
import mapper.RoleMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/13 19:53
 */
public class RoleTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    // 从spring容器中获取mapper代理对象
    RoleMapper roleMapper = context.getBean(RoleMapper.class);
    @Test
    public void  seleteRole(){
        List<Role> roleList = roleMapper.selectAllRole();
        System.out.println(roleList.size());
    }
    @Test
    public  void add(){
        Role role = new Role();
        role.setDescription("123");
        role.setRoleName("test");
        role.setRoleSign("xxx");
        roleMapper.insert(role);
    }
    @Test
    public void seletByUserId(){
        Role role = roleMapper.selectRolesByUserId(1l);
        System.out.println(role);
    }
}
