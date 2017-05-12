package service.impl;

import entity.User;
import entity.UserExample;
import mapper.UserMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/11 20:21
 */
@Service
public class UserServiceImpl  implements UserService{
    @Resource
    UserExample userExample;
    @Autowired
    UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    /**@author yu
     * @version 1.0
     * @Date 2017/5/11
     *
     */
    public User authentication(User user) {
        return userMapper.authentication(user);
    }
    public User selectByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        final List<User> list = userMapper.selectByExample(example);
        return list.get(0);
    }

    public void insert(User user) {
        Md5Hash md5Hash = new Md5Hash(user.getPassword());
        user.setPassword(md5Hash.toString());
        userMapper.insert(user);
    }

    public List<User> selectAll() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIsNotNull();
        return userMapper.selectByExample(userExample);
    }
}
