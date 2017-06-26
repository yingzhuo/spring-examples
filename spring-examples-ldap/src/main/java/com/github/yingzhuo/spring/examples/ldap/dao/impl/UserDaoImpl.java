/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **     |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.ldap.dao.impl;

import com.github.yingzhuo.spring.examples.ldap.dao.UserDao;
import com.github.yingzhuo.spring.examples.ldap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.ContainerCriteria;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Repository;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import java.util.List;
import java.util.Optional;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Override
    public User findByUid(final String uid) {

        final ContainerCriteria query = LdapQueryBuilder.query().where("uid").is(uid);
        List<User> list = ldapTemplate.search(query, (AttributesMapper<User>) attributes -> {
            User user = new User();
            user.setUid(uid);

            Optional<Attribute> mail = Optional.ofNullable(attributes.get("mail"));
            Optional<Attribute> mobile = Optional.ofNullable(attributes.get("mobile"));

            mail.ifPresent(it -> {
                try {
                    user.setMail(it.get().toString());
                } catch (NamingException e) {
                    throw new IllegalStateException(e);
                }
            });

            mobile.ifPresent(it -> {
                try {
                    user.setMobile(it.get().toString());
                } catch (NamingException e) {
                    throw new IllegalStateException(e);
                }
            });

            return user;
        });

        if (list.isEmpty()) {
            return null;
        }

        if (list.size() != 1) {
            throw new DataAccessException(null) {
            };
        }

        return list.get(0);
    }

}
