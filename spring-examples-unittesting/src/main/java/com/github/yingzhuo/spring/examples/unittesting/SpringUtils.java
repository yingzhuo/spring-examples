/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **     |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.unittesting;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class SpringUtils implements EnvironmentAware {

    private static List<String> PROFILES;
    private static Set<String> PROFILES_SET;

    @Override
    public void setEnvironment(Environment environment) {
        SpringUtils.PROFILES = Collections.unmodifiableList(Arrays.asList(environment.getActiveProfiles()));
        SpringUtils.PROFILES_SET = Collections.unmodifiableSet(new HashSet<>(PROFILES));
    }

    public static List<String> getProfiles() {
        return PROFILES;
    }

    public static Set<String> getProfilesAsSet() {
        return PROFILES_SET;
    }

}
