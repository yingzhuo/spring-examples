package unittesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;

@Deprecated
@SpringBootConfiguration
public class ApplicationTestBoot {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTestBoot.class, args);
    }

}
