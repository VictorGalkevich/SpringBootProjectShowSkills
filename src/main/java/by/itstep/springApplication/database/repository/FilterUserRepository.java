package by.itstep.springApplication.database.repository;

import by.itstep.springApplication.database.entity.Role;
import by.itstep.springApplication.database.entity.User;
import by.itstep.springApplication.dto.PersonalInfo;
import by.itstep.springApplication.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Long companyId, Role role);

    void updateCompanyAndRole(List<User> users);

    void updateCompanyAndRoleNamed(List<User> users);
}
