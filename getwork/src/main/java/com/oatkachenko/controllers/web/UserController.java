package com.oatkachenko.controllers.web;

import com.oatkachenko.Transformers.Transformer;
import com.oatkachenko.model.dto.UserDto;
import com.oatkachenko.model.entity.Role;
import com.oatkachenko.model.entity.User;
import com.oatkachenko.services.UserService;
import com.oatkachenko.services.impl.AuthService;
import com.oatkachenko.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Date;
import java.util.Calendar;

/**
 * Web UI контроллер
 */
@Controller
@RequestMapping(value = "/")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthService authService;
    @Autowired
    UserValidator userValidator;

    /**
     * @return главная страница
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        return new ModelAndView("index");
    }

    /**
     * @return старница с формой для входа
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    /**
     * @return старница с формой для регистрации
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm() {
        return new ModelAndView("registration-form", "userForm", new UserDto());
    }

    /**
     * Обработка данных при регистрации пользователя
     *
     * @param userDto прокси-обьект пользователя
     * @param result  обьект для хранения результатов валидации
     * @return в случае успешной валидации, возвращает форму для входа,
     * иначе форму для регистрации с информацией об ошибках
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute("userForm") UserDto userDto,
                                BindingResult result) {
        userValidator.validate(userDto, result);
        if (result.hasErrors()) {
            return new ModelAndView("registration-form");
        }
        User validatedUser = Transformer.userFromDto(userDto);
        validatedUser.setRole(Role.ROLE_USER);
        validatedUser.setJoined(new Date(Calendar.getInstance().getTimeInMillis()));
        userService.save(validatedUser);
        return new ModelAndView("redirect:/login");
    }

    /**
     * @return страница о пользователе
     */
    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public ModelAndView userPage() {
        UserDto userDto = Transformer.dtoFromUser(userService.getById(authService.getAuthenticatedUser().getId()));
        return new ModelAndView("userPage", "user", userDto);
    }

}