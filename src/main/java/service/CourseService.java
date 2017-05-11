package service;

import entity.Course;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/4 12:14
 */
public interface CourseService {
    public List<Course> getAll();
    public void add(Course course);
    public void delete(String course_id);
    public void update(Course course);
    public Course findById(String course_id);
}
