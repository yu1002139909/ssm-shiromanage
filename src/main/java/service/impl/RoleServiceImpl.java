package service.impl;

import entity.Role;
import mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.RoleService;

import java.util.List;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    public List<Role> seletAllRole() {
        return roleMapper.selectAllRole();
    }

    public void insert(Role role) {
        roleMapper.insert(role);
    }

    public Role selectRolesByUserId(Long id) {
        return roleMapper.selectRolesByUserId(id);
    }
}
