package service.impl;

import entity.Course;
import mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CourseService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/4 12:15
 */
@Service
public class CouserServiceImpl  implements CourseService{
    @Autowired
    private CourseMapper courseMapper;

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public List<Course> getAll() {
        return courseMapper.getall();
    }
    public void add(Course course) {
       courseMapper.add(course);
    }
    public void delete(String course_id) {
        courseMapper.delete(course_id);
    }
    public void update(Course course) {
        courseMapper.update(course);
    }
    public Course findById(String course_id) {
        return courseMapper.findById(course_id);
    }
}
