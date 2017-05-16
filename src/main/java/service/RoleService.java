package service;

import entity.Role;

import java.util.List;

/**
 * 角色 业务接口
 * 
 * @author StarZou
 * @since 2014年6月10日 下午4:15:01
 **/
public interface RoleService {
     /**@author yu
      * @version 1.0
      * @Date 2017/5/13
      * 查询所有角色
      */
     List<Role> seletAllRole();
     /**@author yu
      * @version 1.0
      * @Date 2017/5/16
      *新增角色
      */
     void insert(Role role);
     /**@author yu
      * @version 1.0
      * @Date 2017/5/16
      *根据用户id查询角色
      */
     Role selectRolesByUserId(Long id);
}
