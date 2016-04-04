package com.oatkachenko.model.dao;

import com.oatkachenko.model.entity.Task;
import com.oatkachenko.model.entity.User;

import java.util.List;
import java.util.Set;

/**
 * TaskDao интерфейс
 */
public interface TaskDao {
    /**
     * CRUD
     */
    Task save(Task task);

    Task update(Task task);

    Task getById(Long id);

    List<Task> getAll();

    /**
     * @param id id категории
     * @return список всех заказов в данной категории
     */
    List<Task> getTasksByCategoryId(Long id);

    /**
     * @param userId - id пользователя
     * @param taskId - id задания
     * @return - true если пользователь может подать заявку на участие
     */
    boolean addUserAsFreelancer(long userId, long taskId);

    /**
     * @param taskId - id задания
     * @return - список пользователей выполняющих задание
     */
    Set<User> getFreelancersByTask(long taskId);
}