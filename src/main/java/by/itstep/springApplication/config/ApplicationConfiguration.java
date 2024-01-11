package by.itstep.springApplication.config;

import by.itstep.springApplication.database.pool.ConnectionPool;
import by.itstep.springApplication.database.repository.UserRepository;
import by.itstep.webApplication.config.WebConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

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
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.ENGLISH);
        return slr;
    }

}
