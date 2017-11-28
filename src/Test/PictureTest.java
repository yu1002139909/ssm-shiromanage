import entity.Picture;
import mapper.PictureMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/6/5 18:44
 */
public class PictureTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    // 从spring容器中获取mapper代理对象
    PictureMapper pictureMapper = context.getBean(PictureMapper.class);
    @Test
    public void add(){
        Picture picture = new Picture();
        picture.setSrc("test");
        pictureMapper.add(picture);
   }
    @Test
    public void getAll(){
        List<Picture> pictureList = pictureMapper.getall();
       for(Picture picture:pictureList){
           System.out.println(picture.getSrc());
       }
    }
}
