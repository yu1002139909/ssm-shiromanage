package dao;

import entity.Course;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/1 20:10
 */
public class CourseDaoImpl implements  CourseDao{
    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Course> getAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList(Course.class.getName()+".getall");
    }

    public List<Course> getByAll(String id) {
        return null;
    }

    public List<Course> getAll(String id) {
        return null;
    }

    public void add(Course course) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
         sqlSession.insert(Course.class.getName()+".add",course);
    }

    public void delete(String course_id) {
    }

    public void update(Course major) {

    }

    public Course findByid(String course_id) {
        return null;
    }
}
