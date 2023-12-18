package by.itstep.springApplication;

import by.itstep.springApplication.config.ApplicationConfiguration;
import by.itstep.springApplication.database.pool.ConnectionPool;
import by.itstep.springApplication.database.repository.CrudRepository;
import by.itstep.springApplication.service.CompanyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
@ConfigurationPropertiesScan
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);
        System.out.println(run.getBeanDefinitionCount());
    }
}