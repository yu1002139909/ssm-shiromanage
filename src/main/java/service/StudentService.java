package service;

import entity.Student;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/8 16:51
 */
public interface StudentService {
    public List<Student> getall();
    public void add(Student student);
    public void delete(String grade_id);
    public void update(Student studnet);
    public Student findById(String grade_id);
}
