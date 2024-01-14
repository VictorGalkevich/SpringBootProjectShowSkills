package by.itstep.springApplication.dto;

import by.itstep.springApplication.database.entity.Role;
import by.itstep.springApplication.validation.UserInfo;
import by.itstep.springApplication.validation.group.CreateAction;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo
public class UserCreateEditDto {
    @Email
    String username;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @Size(min = 3, max = 64)
    String firstname;

    String lastname;

    @NotBlank(groups = CreateAction.class)
    String rawPassword;

    Role role;

    Long companyId;

    MultipartFile image;
}
