package by.itstep.springApplication.service;

import by.itstep.springApplication.database.entity.Company;
import by.itstep.springApplication.database.repository.CompanyRepository;
import by.itstep.springApplication.dto.CompanyReadDto;
import by.itstep.springApplication.listener.entity.AccessType;
import by.itstep.springApplication.listener.entity.EntityEvent;
import by.itstep.springApplication.mapper.CompanyReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CompanyReadMapper companyReadMapper;

    public Optional<CompanyReadDto> findById(Long id) {
        return companyRepository.findById(id)
                .map(entity -> {
                    applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.getId(), null);
                });
    }

    public List<CompanyReadDto> findAll() {
        return companyRepository.findAll().stream()
                .map(companyReadMapper::map)
                .toList();
    }
}
