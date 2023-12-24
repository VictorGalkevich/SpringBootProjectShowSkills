package by.itstep.springApplication.database.repository;

import by.itstep.springApplication.database.entity.User;
import by.itstep.springApplication.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);
}
