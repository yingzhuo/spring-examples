/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **    |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.shiro;

import com.github.yingzhuo.spring.examples.shiro.realm.WorkhourseRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.concurrent.TimeUnit;

@Configuration
public class ApplicationConfigShiro {

    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());
        return factoryBean;
    }

    @Bean
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    @ConditionalOnMissingBean(DefaultAdvisorAutoProxyCreator.class)
    public static DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher bean = new HashedCredentialsMatcher();
        bean.setHashAlgorithmName("MD5");
        bean.setStoredCredentialsHexEncoded(true);
        bean.setHashIterations(1);
        return bean;
    }

    @Bean
    public SessionDAO sessionDao() {
        return new MemorySessionDAO();
    }

    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDao());
        sessionManager.setGlobalSessionTimeout(TimeUnit.HOURS.toMillis(12)); // 12 hours
        return sessionManager;
    }

    @Bean
    public WorkhourseRealm workhourseRealm() {
        WorkhourseRealm realm = new WorkhourseRealm();
        realm.setCredentialsMatcher(credentialsMatcher());
        return realm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager bean = new DefaultWebSecurityManager();
        bean.setRealm(workhourseRealm());
        bean.setSessionManager(sessionManager());
        return bean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager());
        return advisor;
    }

}