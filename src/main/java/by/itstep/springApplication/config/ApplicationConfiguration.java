package by.itstep.springApplication.config;

import by.itstep.springApplication.database.pool.ConnectionPool;
import by.itstep.springApplication.database.repository.UserRepository;
import by.itstep.webApplication.config.WebConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Import(WebConfig.class)
@Configuration
@ComponentScan(basePackages = "by.itstep.springApplication")
public class ApplicationConfiguration {
    @Bean
    public ConnectionPool pool2(@Value("${db.username}") String name) {
        return new ConnectionPool(name, 10);
    }

    @Bean
    public ConnectionPool pool3() {
        return new ConnectionPool("text ", 20);
    }

    @Bean
    @Profile("prod")
    public UserRepository userRepository2(@Qualifier("pool2") ConnectionPool connectionPool) {
        return new UserRepository(connectionPool);
    }

    @Bean
    public UserRepository userRepository3() {
        return new UserRepository(pool3());
    }
}
