package unittesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = "")
public class ApplicationTestBoot {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTestBoot.class, args);
    }

}
