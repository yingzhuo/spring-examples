package unittesting.dao;

import com.github.yingzhuo.spring.examples.unittesting.ApplicationBoot;
import com.github.yingzhuo.spring.examples.unittesting.dao.UserDao;
import com.github.yingzhuo.spring.examples.unittesting.domain.User;
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
@ActiveProfiles({"ut", "xxx", "yyy"})
@Sql("classpath:/hsql/schema.sql")
@Sql("classpath:/hsql/data.sql")
public class UserDaoTestCase {

    @Autowired
    private UserDao userDao;

    /*
     * 在注释务必写明白测试的目的，测试的期望结果
     */
    @Test
    public void testCase1() {
        User user = userDao.findById("1");
        Assert.assertNotEquals(null, user);
        Assert.assertEquals("1", user.getId());
        Assert.assertEquals("尹英椿", user.getName());
    }

    /*
     * 在注释务必写明白测试的目的，测试的期望结果
     */
    @Test
    public void testCase2() {
        User user = userDao.findById("-1");
        Assert.assertEquals(null, user);
    }

}
