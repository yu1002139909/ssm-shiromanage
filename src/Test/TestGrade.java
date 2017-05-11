import entity.Grade;
import mapper.GradeMapper;
import mapper.MajorMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/8 17:31
 */
public class TestGrade {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    // 从spring容器中获取mapper代理对象
    GradeMapper gradeMapper = context.getBean(GradeMapper.class);
    MajorMapper majorMapper = context.getBean(MajorMapper.class);
    @Test
    public  void add(){
        Grade grade = new Grade();
        grade.setGrade_name("test");
        grade.setGmajor_id(majorMapper.findById("bc3ff01282b6103594d0392f41b8d916").getMajor_id());
        grade.setPhoto("ss");

        grade.setYear("2015");
        gradeMapper.add(grade);
    }
    @Test
    public  void getall(){
        List<Grade> gradeList = gradeMapper.getall();
        for (Grade grade:gradeList){
            System.out.println(grade.getMajor().getMajor_id());
        }
    }
    @Test
    public  void findById(){
        Grade grade = gradeMapper.findById("6648f99185c5103580d7e7d881007961");
        System.out.println(grade.getGrade_name());
    }
    @Test
    public  void findByMjor_id(){
        List<Grade> grades = gradeMapper.findbyGradeMapperByMajorId("de6ab1fc8518103580d7e7d881007961");
        for (Grade grade: grades){
            System.out.println(grade.getGrade_name());
        }
    }
}
