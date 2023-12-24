package by.itstep.springApplication.database.repository;

import by.itstep.springApplication.database.entity.Role;
import by.itstep.springApplication.database.entity.User;
import by.itstep.springApplication.database.pool.ConnectionPool;
import by.itstep.springApplication.dto.PersonalInfo;
import by.itstep.springApplication.dto.PersonalInfoInterface;
import jakarta.persistence.Entity;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>, FilterUserRepository {
    List<User> findAllByFirstnameContainingAndLastnameContaining(String firstname, String lastname);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = ?1 where u.id in (?2)")
    int updateRole(Role role, Long... ids);

    Optional<User> findTopByOrderByIdDesc();

    @Lock(LockModeType.PESSIMISTIC_READ)
    @QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value = "50"))
    List<User> findTop3ByBirthDateBefore(LocalDate birthDate, Sort sort);

    //Collection, Stream, Streamable, Slice, Page
    //@EntityGraph("User.company")
    @EntityGraph(attributePaths = {"company", "company.locales"})
    @Query(value = "select u from User u", countQuery = "select count(distinct u.firstname) from User u")
    Page<User> findAllBy(Pageable pageable);

    @Query(value = "SELECT firstname, lastname, birth_date birthDate FROM users WHERE company_id = ?1", nativeQuery = true)
    List<PersonalInfoInterface> findAllByCompanyId(Long companyId);

    //<T> List<T> findAllByCompanyId(Long companyId, Class<T> clazz);
}