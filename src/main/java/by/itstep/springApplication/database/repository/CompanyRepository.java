package by.itstep.springApplication.database.repository;

import by.itstep.springApplication.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("select c from Company c join fetch c.locales cl where c.name=?1")
    Optional<Company> findByName(String name);
    List<Company> findAllByNameContainingIgnoreCase(String fragment);
}