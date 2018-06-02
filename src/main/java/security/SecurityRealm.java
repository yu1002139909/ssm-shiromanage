package security;

import entity.LyUser;
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
import service.LyUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户身份验证,授权 Realm 组件
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Autowired
    private LyUserService lyUserService;


    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = String.valueOf(principals.getPrimaryPrincipal());

        final LyUser user = lyUserService.findByUserName(username);
        // 添加角色
        System.out.println(user);
        List<String> roles = new ArrayList<String>();
        roles.add(user.getRole());
        authorizationInfo.addRoles(roles);
        return authorizationInfo;
    }
    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        // 通过数据库进行验证
        final LyUser authentication = lyUserService.authentication(new LyUser(username, password));
        if (authentication == null) {
            throw new AuthenticationException("用户名或密码错误.");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        return authenticationInfo;
    }
}
