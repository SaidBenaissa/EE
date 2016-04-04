package com.oatkachenko.controllers.api;

import com.oatkachenko.Transformers.Transformer;
import com.oatkachenko.model.dto.UserDto;
import com.oatkachenko.model.entity.Task;
import com.oatkachenko.model.entity.User;
import com.oatkachenko.services.TaskService;
import com.oatkachenko.services.UserService;
import com.oatkachenko.services.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * API контроллер для работы с пользователями
 */
@Controller
@RequestMapping(value = "/api/users")
public class ApiUserController {
    @Autowired
    AuthService authService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    /**
     * @param id - идентификатор пользователя
     * @return - пользователь
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserDto getUserById(@PathVariable("id") Long id) {
        return Transformer.dtoFromUser(userService.getById(id));
    }

    /**
     * @param id - id пользователя
     * @return - список заданий в которых пользователь является в роли Заказчика
     */
    @RequestMapping(value = "/user/task/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Set<Task>> getUsersTaskAsOwner(@PathVariable("id") Long id) {
        List<Set<Task>> usersTask = new ArrayList<>();
        User byId = userService.getById(id);
        usersTask.add(byId.getTaskListAsOwner());
        usersTask.add(byId.getTaskListAsFreelancer());
        return usersTask;
    }

    /**
     * @param id - id задания
     * @return - список пользователей подавших заявку на участие
     */
    @RequestMapping(value = "/bids/task/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDto> getBidsForTask(@PathVariable("id") Long id) {
        List<UserDto> dtos = new ArrayList<>();
        taskService.getFreelancersByTask(id).forEach(user ->
        {
            dtos.add(Transformer.dtoFromUser(user));
        });
        return dtos;
    }


}