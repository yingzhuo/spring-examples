/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **    |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.retry.service.impl;

import com.github.yingzhuo.spring.examples.retry.service.NumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("numberService")
public class NumberServiceImpl implements NumberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberServiceImpl.class);

    private final Random random = new Random();

    public Integer getRandomOddInteger() {
        int n = random.nextInt();
        if (n % 2 == 0) {
            LOGGER.warn("随机生成了一个偶数...");
            throw new IllegalStateException("随机生成了一个偶数...");
        } else {
            LOGGER.debug("随机生成了一个奇数...");
        }
        return n;
    }

}
