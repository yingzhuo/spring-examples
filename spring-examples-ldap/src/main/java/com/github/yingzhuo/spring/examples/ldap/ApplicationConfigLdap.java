package com.github.yingzhuo.spring.examples.ldap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
@EnableConfigurationProperties
public class ApplicationConfigLdap {

    @Bean
    @ConfigurationProperties(prefix = "spring.ldap.context-source")
    public LdapContextSource ldapContextSource() {
        LdapContextSource bean = new LdapContextSource();
//        bean.setUrl("ldap://10.211.55.13:389");
//        bean.setBase("ou=people,dc=yingzhuo,dc=org");
//        bean.setUserDn("cn=admin,dc=yingzhuo,dc=org");
//        bean.setPassword("133810");
        return bean;
    }

    @Bean
    public LdapTemplate ldapTemplate(LdapContextSource ldapContextSource) {
        return new LdapTemplate(ldapContextSource);
    }
}
