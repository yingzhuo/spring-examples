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
