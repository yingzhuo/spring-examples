/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **     |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.ehcache.service.impl;

import com.github.yingzhuo.spring.examples.ehcache.domain.User;
import com.github.yingzhuo.spring.examples.ehcache.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Override
    @Cacheable(cacheNames = "userCache")
    public User findUserById(String id) {
        LOGGER.debug("查找用户");

        if (null == id) {
            return null;
        }
        return new User(id, "name_" + id);
    }

    @Override
    @CacheEvict(cacheNames = "userCache")
    public void deleteUserById(String id) {
        LOGGER.debug("删除用户");
    }

}
