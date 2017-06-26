/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **    |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.shiro.realm;

import com.github.yingzhuo.spring.examples.shiro.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

public class WorkhourseRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        User user = (User) super.getAvailablePrincipal(principals);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(new HashSet<>(Arrays.asList("ROLE_USER", "ROLE_ADMIN")));
        info.setStringPermissions(new HashSet<>());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token instanceof UsernamePasswordToken) {
            final String username = ((UsernamePasswordToken) token).getUsername();
            final String password = new String(((UsernamePasswordToken) token).getPassword());

            final User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setUsername(username);
            user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)));

            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        }
        throw new UnsupportedTokenException();
    }

}
