package by.itstep.springApplication.config;

import by.itstep.springApplication.Main;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableEnversRepositories(basePackageClasses = Main.class)
@EnableJpaAuditing
public class AuditingConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("victordev");
    }
}
