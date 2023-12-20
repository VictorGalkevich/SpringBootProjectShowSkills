package by.itstep.springApplication.database.repository;

import by.itstep.springApplication.database.entity.User;
import by.itstep.springApplication.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstnameContainingAndLastnameContaining(String firstname, String lastname);
}