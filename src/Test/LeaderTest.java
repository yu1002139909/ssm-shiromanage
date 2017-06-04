import entity.Leader;
import mapper.LeaderMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/6/3 14:39
 */
public class LeaderTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    // 从spring容器中获取mapper代理对象
    LeaderMapper leaderMapper = context.getBean(LeaderMapper.class);

    @Test
    public void add(){
        Leader leader = new Leader();
        leader.setName("张校长");
        leader.setEnterDate(new Date());
        leader.setNowDate(new Date());
        leader.setWork("测试");
        leader.setState("退休");
        leader.setSynopsis("测试");
        leader.setPhoto("你好");
        leaderMapper.add(leader);
    }
    @Test
    public void getAll(){
        List<Leader> leaderList = leaderMapper.getall();
        for (Leader leader:leaderList){
            System.out.println(leader);
        }
    }
    @Test
    public void findByPersion(){
        List<Leader> leaderList = leaderMapper.findByPosition("离职");
        for (Leader leader:leaderList){
            System.out.println(leader.getName());
        }
     }
}
