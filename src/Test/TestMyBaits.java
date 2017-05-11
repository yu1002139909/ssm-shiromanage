import mapper.CourseMapper;
import mapper.MajorMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/4 18:55
 */
public class TestMyBaits {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 从spring容器中获取mapper代理对象
        MajorMapper majorMapper = context.getBean(MajorMapper.class);
        CourseMapper courseMapper = context.getBean(CourseMapper.class);
    }

}
