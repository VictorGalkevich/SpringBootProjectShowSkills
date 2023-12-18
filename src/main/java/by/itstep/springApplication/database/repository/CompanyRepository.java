package by.itstep.springApplication.database.repository;

import by.itstep.springApplication.bpp.Auditing;
import by.itstep.springApplication.bpp.Transaction;
import by.itstep.springApplication.database.entity.Company;
import by.itstep.springApplication.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Repository
@Auditing
@Transaction
@RequiredArgsConstructor
@Slf4j
public class CompanyRepository implements CrudRepository<Long, Company>{

    @Qualifier("pool1")
    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @Override
    public Optional<Company> finById(Long id) {
        log.info("findById method...");
        return Optional.of(new Company(id, null, Collections.emptyMap()));
    }

    @Override
    public void delete(Company entity) {
        log.info("delete method...");
    }
}