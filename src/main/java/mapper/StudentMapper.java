package mapper;

import entity.Student;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/8 16:51
 */
public interface StudentMapper {
    public List<Student> getall();
    public void add(Student student);
    public void delete(String id);
    public void update(Student studnet);
    public Student findById(String id);
    public List<Student> findByGradeId(String grade_id);
}
