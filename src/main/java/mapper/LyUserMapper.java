package mapper;

import entity.LyUser;

import java.math.BigInteger;
import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/4 19:39
 */
public interface LyUserMapper {
    /**
     *新增
     * @param lyUser
     */
    void add(LyUser lyUser);

    /**
     * 获取所有用户
     * @return
     */
    List<LyUser> getAll();

    /**
     * 修改用户
     * @param user
     */
    void update(LyUser user);

    /**
     * 删除用户
     * @param id
     */
    void delete(BigInteger id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    LyUser  findById(BigInteger id);
    /**
     * 用户验证
     *
     * @param user
     * @return
     */
    LyUser authentication(LyUser user);

    /**
     * 用户验证
     *
     * @param userName
     * @return
     */
    LyUser findByUserName(String userName);

    /**
     * 修改用户状态
     * @param user
     */
    void updateUserState(LyUser user);

    /**
     * 添加用户角色
     * @param user
     */
    void addUserRole(LyUser user);

    /**
     * 查询管理员列表
     * @return
     */
    List<LyUser> AdminList();
}
