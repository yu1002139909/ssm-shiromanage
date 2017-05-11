package mapper;

import entity.Course;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/4 11:09
 */
public interface CourseMapper {
    public List<Course> getall();
    public void add(Course course);
    public void delete(String course_id);
    public void update(Course course);
    public Course findById(String course_id);

}
