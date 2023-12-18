package by.itstep.springApplication.service;

import by.itstep.springApplication.database.entity.Company;
import by.itstep.springApplication.database.repository.CrudRepository;
import by.itstep.springApplication.dto.CompanyReadDto;
import by.itstep.springApplication.listener.entity.AccessType;
import by.itstep.springApplication.listener.entity.EntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final UserService userService;
    private final CrudRepository<Long, Company> companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public Optional<CompanyReadDto> findById(Long id) {
        return companyRepository.finById(id)
                .map(entity -> {
                    applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.getId());
                });
    }
}
