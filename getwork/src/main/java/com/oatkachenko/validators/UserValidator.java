package com.oatkachenko.validators;

import com.oatkachenko.model.dto.UserDto;
import com.oatkachenko.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


/**
 * Created by Home on 24.03.2016.
 */
@Component
public class UserValidator implements Validator {
    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        UserDto dto = (UserDto) obj;

        String username = dto.getUsername();
        String email = dto.getEmail();

        if (userService.getByEmail(email) != null){
            errors.rejectValue("email", "email.exist", "* email уже существует");
        }
        if (userService.getByUsername(username) != null) {
            errors.rejectValue("username", "login.exist", "* логин уже существует");
        }
        if (!dto.getPassword().equals(dto.getPassword2())){
            errors.rejectValue("password2", "password.not_equals", "* пароли не совпадают");
        }

    }
}
