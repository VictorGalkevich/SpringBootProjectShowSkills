package by.itstep.springApplication.service;

import by.itstep.springApplication.database.entity.Company;
import by.itstep.springApplication.database.repository.CompanyRepository;
import by.itstep.springApplication.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
}