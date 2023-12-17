package by.itstep.service;

import by.itstep.database.entity.Company;
import by.itstep.database.repository.CompanyRepository;
import by.itstep.database.repository.CrudRepository;
import by.itstep.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository,
                       CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}