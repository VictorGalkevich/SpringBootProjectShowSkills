package by.itstep;

import by.itstep.config.ApplicationConfiguration;
import by.itstep.database.pool.ConnectionPool;
import by.itstep.database.repository.CompanyRepository;
import by.itstep.database.repository.CrudRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ConnectionPool pool2;
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            //System.out.println(classPathXmlApplicationContext.getBean(ConnectionPool.class));
            pool2 = context.getBean("pool1", ConnectionPool.class);
            CrudRepository companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(pool2);
            System.out.println(companyRepository.finById(1));
        }
    }
}