package dao;

import entity.Course;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/1 20:09
 */
public interface CourseDao {
    public List<Course> getAll();
    public void add(Course course);
    public void delete(String course_id);
    public void update(Course major);
    public  Course findByid(String course_id);
}
