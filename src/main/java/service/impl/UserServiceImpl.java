package service.impl;

import entity.User;
import entity.UserExample;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/16 14:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserExample userExample;
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
        userMapper.insert(user);
    }

    public List<User> selectAll() {
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIsNotNull();
        return userMapper.selectByExample(userExample);
    }

    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
