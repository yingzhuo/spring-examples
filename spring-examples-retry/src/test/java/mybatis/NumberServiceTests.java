package mybatis;

import com.github.yingzhuo.spring.examples.retry.ApplicationBoot;
import com.github.yingzhuo.spring.examples.retry.service.NumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ApplicationBoot.class)
public class NumberServiceTests {

    @Autowired
    NumberService numberService;

    @Test
    public void test1() {
        numberService.getRandomOddInteger();
    }
}
