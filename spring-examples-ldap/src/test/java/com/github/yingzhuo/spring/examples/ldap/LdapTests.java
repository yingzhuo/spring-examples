package com.github.yingzhuo.spring.examples.ldap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ApplicationBoot.class)
public class LdapTests {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Test
    public void test1() throws Exception {
        System.out.println("----开始");
        Object object = ldapTemplate.search(LdapQueryBuilder.query().where("cn").is("yingzhuo"), new AttributesMapper<String>() {
            @Override
            public String mapFromAttributes(Attributes attributes) throws NamingException {
                return attributes.get("cn").get().toString();
            }
        });
        System.out.println("----结束");
        System.out.println(object);
    }

}
