package com.oatkachenko.controllers.api;

import com.oatkachenko.model.entity.Task;
import com.oatkachenko.services.TaskService;
import com.oatkachenko.services.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *  API контроллер для работы с заданиями
 */
@Controller
@RequestMapping(value = "/api/tasks")
public class ApiTaskController {
    @Autowired
    AuthService authService;
    @Autowired
    private TaskService taskService;

    /**
     *
     * @param id - идентификатор категории
     * @return  - Список всех открытых заданий из определенной категории
     */
    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Task> getAllTasksByCategoryId(@PathVariable("id") Long id) {
        return taskService.getTasksByCategoryId(id);
    }

    /**
     *
     * @param id - идентификатор задания
     * @return - задание
     */
    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getById(id);
    }


}