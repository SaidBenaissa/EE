package com.oatkachenko.services;

import com.oatkachenko.model.entity.Task;
import com.oatkachenko.model.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Home on 21.03.2016.
 */
public interface TaskService {
    Task getById(long id);

    List<Task> getTasksByCategoryId(Long id);

    Task save(Task task);

    Task update(Task task);

    boolean delete(Task task);

    List<Task> findAll();
    Set<User> getFreelancersByTask(long taskId);

    boolean addUserAsFreelancer(long userId, Long taskId);
}
