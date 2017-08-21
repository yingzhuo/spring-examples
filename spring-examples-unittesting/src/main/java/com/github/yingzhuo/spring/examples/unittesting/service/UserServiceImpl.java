/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **     |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.unittesting.service;

import com.github.yingzhuo.spring.examples.unittesting.SpringUtils;
import com.github.yingzhuo.spring.examples.unittesting.dao.UserDao;
import com.github.yingzhuo.spring.examples.unittesting.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findUserById(String userId) {
        return userDao.findById(userId);
    }

    @Override
    public User complexMethod() {
        if (SpringUtils.getProfilesAsSet().contains("ut")) {
            return new User();
        }

        throw new UnsupportedOperationException();
    }
}
