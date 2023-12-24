package by.itstep.springApplication.integration.database.repository;

import by.itstep.springApplication.database.entity.Role;
import by.itstep.springApplication.database.entity.User;
import by.itstep.springApplication.database.repository.UserRepository;
import by.itstep.springApplication.dto.PersonalInfo;
import by.itstep.springApplication.dto.PersonalInfoInterface;
import by.itstep.springApplication.dto.UserFilter;
import by.itstep.springApplication.integration.annotatation.IT;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkAuditing() {
        User user = userRepository.findById(1L).get();
        user.setBirthDate(user.getBirthDate().plusYears(1L));
        userRepository.flush();
        System.out.println();
    }

    @Test
    void checkCustomImplementation() {
        UserFilter filter = new UserFilter(null, "%ov%", LocalDate.now());
        List<User> allByFilter = userRepository.findAllByFilter(filter);
        System.out.println(allByFilter);
    }


    @Test
    void checkProjections() {
        List<PersonalInfoInterface> allByCompanyId = userRepository.findAllByCompanyId(1L);
        System.out.println(allByCompanyId);
    }

    @Test
    void checkPageable() {
        PageRequest id = PageRequest.of(0, 2, Sort.by("id"));
        Slice<User> slice = userRepository.findAllBy(id);
        slice.forEach(user -> System.out.println(user.getCompany().getName()));

        while (slice.hasNext()) {
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(user -> System.out.println(user.getCompany().getName()));
        }
    }

    @Test
    void checkSort() {
        Sort sort = Sort.by("id").and(Sort.by("firstname"));
        var sortUser = Sort.sort(User.class);
        sortUser.by(User::getFirstname).and(sortUser.by(User::getLastname));
        List<User> users = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sortUser);
        Assertions.assertThat(users).hasSize(3);
    }

    @Test
    void checkTopThree() {
        List<User> users = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), Sort.by("id").descending());
        Assertions.assertThat(users).hasSize(3);
    }

    @Test
    void checkFirstTop() {
        Optional<User> topUser = userRepository.findTopByOrderByIdDesc();
        assertTrue(topUser.isPresent());
        topUser.ifPresent(user -> assertEquals(5L, user.getId()));
    }

    @Test
    void checkUpdate() {
        int i = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, i);
    }

    @Test
    void findAllByFirstNameContainingAndLastNameContaining() {
        List<User> allByFirstNameContainingAndLastNameContaining = userRepository.findAllByFirstnameContainingAndLastnameContaining("a", "ov");
    }
}