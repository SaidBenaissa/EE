package com.oatkachenko.controllers.web;

import com.oatkachenko.Transformers.Transformer;
import com.oatkachenko.model.dto.TaskDto;
import com.oatkachenko.model.entity.Status;
import com.oatkachenko.model.entity.Task;
import com.oatkachenko.model.entity.User;
import com.oatkachenko.services.TaskService;
import com.oatkachenko.services.UserService;
import com.oatkachenko.services.impl.AuthService;
import com.oatkachenko.validators.TaskValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Web UI контроллер для обработки запросов страниц связанных с обработкой заданий
 */

@Controller
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    AuthService authService;
    @Autowired
    TaskService taskService;
    @Autowired
    TaskValidator taskValidator;
    @Autowired
    UserService userService;

    /**
     * @return страницу с формой для создания нового задания
     */
    @RequestMapping(value = "/addForm", method = RequestMethod.GET)
    public ModelAndView addTaskPage() {
        return new ModelAndView("addtask", "taskForm", new TaskDto());
    }

    /**
     * @return страницу поиска заданий
     */
    @RequestMapping(value = "/searchTask", method = RequestMethod.GET)
    public ModelAndView searchTaskPage() {
        return new ModelAndView("searchtask");
    }

    /**
     * Обработка и валидация нового задания
     *
     * @param taskDto прокси-обьект содержащий инфо. о заказе
     * @param result  обьект для хранения результатов валидации
     * @return если валидация пройдена происходит переход на главную страницу, иначе
     * отображается форма создания заказа с информацией, какие поля не прошли валидацию
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveTask(@Valid @ModelAttribute("taskForm") TaskDto taskDto,
                                 BindingResult result) {
        taskValidator.validate(taskDto, result);
        if (result.hasErrors()) {
            return new ModelAndView("addtask");
        }
        Task validatedTask = Transformer.taskFromDto(taskDto);
        User byId = userService.getById(authService.getAuthenticatedUser().getId());
        validatedTask.setCustomer(byId);
        validatedTask.setStatus(Status.OPEN);
        taskService.save(validatedTask);
        return new ModelAndView("redirect:/");
    }

    /**
     * Возвращает страницу с информацией о задании
     *
     * @param id - id задания
     * @return - страница с инфо. о задании
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView taskPage(@PathVariable(value = "id") Long id) {
        return new ModelAndView("taskPage", "id", id);
    }

    /**
     * Подача заявки пользователем на участие в выполнении задания
     *
     * @param id - id заказа
     * @return ту же страницу
     */
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public ModelAndView applyFor(@RequestParam("id") Long id) {
        long taskId = id;
        long userId = authService.getAuthenticatedUser().getId();
        taskService.addUserAsFreelancer(userId, taskId);
        return new ModelAndView("redirect:/task/" + id);
    }
}