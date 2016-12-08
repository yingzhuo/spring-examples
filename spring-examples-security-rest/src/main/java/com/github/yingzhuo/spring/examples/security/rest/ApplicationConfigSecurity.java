package com.github.yingzhuo.spring.examples.security.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public abstract class ApplicationConfigSecurity {

    @Configuration
    public static class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService());
        }

        @Bean
        public UserDetailsService userDetailsService() {
            return username -> {
                System.out.println("hahaha");
                return new User(username, "123456", true, true, true, true,
                        AuthorityUtils.commaSeparatedStringToAuthorityList("USER,ADMIN"));
            };
        }
    }

    @Configuration
    @EnableWebSecurity
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http.authorizeRequests()
                    .anyRequest().fullyAuthenticated()
                        .and()
                    .httpBasic()
                        .and().
                    csrf()
                        .disable()
                    .formLogin()
                        .disable();
            // @formatter:on
        }

//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(this.userDetailsService()).passwordEncoder(null);
//        }
    }

}
