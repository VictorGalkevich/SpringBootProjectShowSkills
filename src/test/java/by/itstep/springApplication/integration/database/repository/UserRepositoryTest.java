package by.itstep.springApplication.integration.database.repository;

import by.itstep.springApplication.database.entity.User;
import by.itstep.springApplication.database.repository.UserRepository;
import by.itstep.springApplication.integration.annotatation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;
    @Test
    void findAllByFirstNameContainingAndLastNameContaining() {
        List<User> allByFirstNameContainingAndLastNameContaining = userRepository.findAllByFirstnameContainingAndLastnameContaining("a", "ov");
    }
}