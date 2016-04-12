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
        return new LdapContextSource();
    }

    @Bean
    public LdapTemplate ldapTemplate(LdapContextSource ldapContextSource) {
        return new LdapTemplate(ldapContextSource);
    }

}
