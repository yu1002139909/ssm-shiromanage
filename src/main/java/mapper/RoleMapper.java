package mapper;

import entity.Role;
import util.GenericDao;

import java.util.List;

/**
 * 角色Dao 接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:55:59
 **/
public interface RoleMapper extends GenericDao<Role, Long> {

    List<Role> selectAllRole();

    void insert(Role rOle);

    Role selectRolesByUserId(Long id);
}