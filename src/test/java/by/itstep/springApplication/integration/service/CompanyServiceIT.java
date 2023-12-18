package by.itstep.springApplication.integration.service;

import by.itstep.springApplication.config.DatabaseProperties;
import by.itstep.springApplication.database.entity.Company;
import by.itstep.springApplication.dto.CompanyReadDto;
import by.itstep.springApplication.integration.annotatation.IT;
import by.itstep.springApplication.listener.entity.EntityEvent;
import by.itstep.springApplication.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@IT
@RequiredArgsConstructor
public class CompanyServiceIT {

    private static final long COMPANY_ID = 1;
    private final CompanyService companyService;
    private final DatabaseProperties properties;
    @Test
    void findById() {
        Optional<CompanyReadDto> actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());

        CompanyReadDto expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(actual, expectedResult));
    }
}
