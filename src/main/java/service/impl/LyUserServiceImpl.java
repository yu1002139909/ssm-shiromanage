package service.impl;

import entity.LyUser;
import mapper.LyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LyUserService;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/4 19:50
 */
@Service
public class LyUserServiceImpl implements LyUserService {
    @Autowired
    LyUserMapper lyUserMapper;
    /**
     * 新增
     *
     * @param lyUser
     */
    @Override
    public void add(LyUser lyUser) {
        lyUserMapper.add(lyUser);
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @Override
    public List<LyUser> getAll() {
        return lyUserMapper.getAll();
    }

    /**
     * 修改用户
     *
     * @param user
     */
    @Override
    public void update(LyUser user) {
            lyUserMapper.update(user);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void delete(BigInteger id) {
        lyUserMapper.delete(id);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public LyUser findById(BigInteger id) {
        return lyUserMapper.findById(id);
    }

    /**
     * 用户验证
     *
     * @param user
     * @return
     */
    @Override
    public LyUser authentication(LyUser user) {
        return lyUserMapper.authentication(user);
    }

    /**
     * 用户验证
     *
     * @param userName
     * @return
     */
    @Override
    public LyUser findByUserName(String userName) {
        return lyUserMapper.findByUserName(userName);
    }

    /**
     * 修改用户状态
     *
     * @param user
     */
    @Override
    public void updateUserState(LyUser user) {
        lyUserMapper.updateUserState(user);
    }

    /**
     * 添加用户角色
     *
     * @param user
     */
    @Override
    public void addUserRole(LyUser user) {
        lyUserMapper.addUserRole(user);
    }

    /**
     * 查询管理员列表
     *
     * @return
     */
    @Override
    public List<LyUser> AdminList() {
        return lyUserMapper.AdminList();
    }
}
