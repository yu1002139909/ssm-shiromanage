import entity.Student;
import mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.StudentService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/10 13:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentTest {
    @Autowired
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    private StudentMapper studentMapper;
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
    @Test
    public void add(){
        Student student = new Student();
        student.setScourse_id("555774c082b6103594d0392f41b8d916");
        student.setPhoto("sss");
        student.setCompany("测试");
        student.setName("哈哈");
        student.setsgrade_id("17e8c43685c9103580d7e7d881007961");
        studentService.add(student);
    }
    @Test
    public void getall(){
        List<Student> studentList = studentService.findByGradeId("40ac5cf58dc21035914c43d563710be4");
        for (Student student:studentList){
            System.out.println(student.getGrade().getMajor());
        }
    }
    @Test
    public void findById(){
        Student student = studentMapper.findById("e324ace186bf10358c4e39e5d476d2bb");
        System.out.println(student.getName());
    }
    @Test
    public void update(){
        Student student = studentMapper.findById("7e2c301686d910358c4e39e5d476d2bb");
        System.out.println(student.getGrade().getGrade_name());
    }
}
