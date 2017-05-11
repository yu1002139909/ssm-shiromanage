package dao;

import entity.Major;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/1 17:32
 */
public class MajorDaoImpl implements MajorDao {
    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Major> getAll(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList(Major.class.getName()+".getall",name);
    }

    public void add(Major major) {

    }

    public void delete(int major_id) {

    }

    public void update(Major major) {

    }

    public Major findByid(int major_id) {
        return null;
    }
}
