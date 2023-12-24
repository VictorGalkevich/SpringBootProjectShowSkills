package by.itstep.springApplication.dto;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.List;

public interface PersonalInfoInterface {
    String getFirstname();

    String getLastname();

    LocalDate getBirthDate();

    @Value("#{target.firstname + ' ' + target.lastname}")
    String getFullName();

}
