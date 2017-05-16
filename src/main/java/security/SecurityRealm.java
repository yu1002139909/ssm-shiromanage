package security;

import entity.Role;
import entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.PermissionService;
import service.RoleService;
import service.UserService;

import javax.annotation.Resource;

/**
 * 用户身份验证,授权 Realm 组件
 * 
 * @author StarZou
 * @since 2014年6月11日 上午11:35:28
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {
    @Override
    public void setName(String name) {
        super.setName("securityRealm");
    }

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Resource
    private RoleService roleService;

    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Resource
    private PermissionService permissionService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = String.valueOf(principals.getPrimaryPrincipal());

       final User user = userService.selectByUsername(username);
       Role roleInfos = roleService.selectRolesByUserId(user.getId());

            // 添加角色
            System.err.println(roleInfos);
            authorizationInfo.addRole(roleInfos.getRoleSign());
      return authorizationInfo;
    }
    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = String.valueOf(token.getPrincipal());
        System.out.println(username);
        String password = new String((char[]) token.getCredentials());
        // 通过数据库进行验证
        final User authentication = userService.authentication(new User(username, password));
        if (authentication == null) {
            throw new AuthenticationException("用户名或密码错误.");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        return authenticationInfo;
    }
}
