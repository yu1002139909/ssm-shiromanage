import dao.CourseDao;
import dao.MajorDao;
import entity.Course;
import entity.Major;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.CourseService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/1 17:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class TestDemo {
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CourseService courseService;
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void setMajorDao(MajorDao majorDao) {
        this.majorDao = majorDao;
    }
    //查询学院下的专业
    @Test
    public void testlist(){
        List<Major> all = majorDao.getAll("机械工程学院");
        for (Major major:all){
            System.out.println(major.getCourse().getCourse_name());
        }
    }
    //查询专业所属学院
    @Test
    public void test2(){
        List<Course> all = courseDao.getAll();
        for (Course course:all){
            List<Major> majorList = course.getMajorList();
            for (Major major :majorList){
                System.out.println(major.getMajor_name());
            }
        }
    }
    @Test
    public void test3(){
          Course course = new Course();
          course.setCourse_name("jj");
          courseDao.add(course);
    }
    @Test
    public void getall(){
        List<Course> all = courseDao.getAll();
        for (Course course:all){
            System.out.println(course.getCourse_id());
        }
    }
    @Test
    public  void  getCourse(){
        List<Course> all = courseService.getAll();
        System.out.println(all.size());
    }
}
