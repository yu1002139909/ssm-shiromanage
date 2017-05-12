package service;

import entity.User;

import java.util.List;

/**
 * 用户 业务 接口
 **/
public interface UserService  {
    /**
     * 用户验证
     * 
     * @param user
     * @return
     */
    User authentication(User user);
    /**
     * 根据用户名查询用户
     * 
     * @param username
     * @return
     */
    User selectByUsername(String username);
    /**@author yu
     * @version 1.0
     * @Date 2017/5/11
     */
     void insert(User user);
/**@author yu
 * @version 1.0
 * @Date 2017/5/12
 * 查询所有管理员
 */
     List<User> selectAll();
}
