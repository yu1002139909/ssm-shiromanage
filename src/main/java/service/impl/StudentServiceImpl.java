package service.impl;

import entity.Student;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StudentService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/10 14:07
 */
@Service
public class StudentServiceImpl implements StudentService {
    //注入mapper
    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> getall() {

        return studentMapper.getall();
    }
    //增加学生
    public void add(Student student) {
        studentMapper.add(student);
    }
    //删除学生
    public void delete(String stuid) {
        studentMapper.delete(stuid);
    }

    public void update(Student studnet) {
        studentMapper.update(studnet);
    }
    //通过主键查询学生信息
    public Student findById(String id) {
        return studentMapper.findById(id);
    }
    //查询班级下有哪些学生
    public List<Student> findByGradeId(String grade_id) {
        return studentMapper.findByGradeId(grade_id);
    }
}
