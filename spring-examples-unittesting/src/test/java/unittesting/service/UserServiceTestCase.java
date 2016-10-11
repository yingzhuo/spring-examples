package unittesting.service;

import com.github.yingzhuo.spring.examples.unittesting.ApplicationBoot;
import com.github.yingzhuo.spring.examples.unittesting.domain.User;
import com.github.yingzhuo.spring.examples.unittesting.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
@ActiveProfiles({"ut"})
@Sql("classpath:/hsql/schema.sql")
@Sql("classpath:/hsql/data.sql")
public class UserServiceTestCase {

    @Autowired
    private UserService userService;

    @Test
    public void testCase1() {
        User user = userService.findUserById("1");
        Assert.assertNotNull(user);
    }

}
