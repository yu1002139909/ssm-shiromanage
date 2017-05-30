package mapper;

import util.GenericDao;
import util.Page;
import entity.User;
import entity.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户Dao接口
 **/
public interface UserMapper extends GenericDao<User, Long> {


    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    /**@author yu
     * @version 1.0
     * @Date 2017/5/25
     *根据主键查询用户角色
     */
    User selectByPrimaryKey(Long id);
    /**
     * 用户登录验证查询
     *
     * @param record
     * @return
     */
    User authentication(@Param("record") User record);

    /**
     * 分页条件查询
     *
     * @param page
     * @param example
     * @return
     */
    List<User> selectByExampleAndPage(Page<User> page, UserExample example);

}