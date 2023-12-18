package by.itstep.springApplication.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional(JpaCondition.class)
@Configuration
@Slf4j
public class JpaConfiguration {
    @PostConstruct
    void init() {
        log.info("Jpa config is enabled");
    }
}
