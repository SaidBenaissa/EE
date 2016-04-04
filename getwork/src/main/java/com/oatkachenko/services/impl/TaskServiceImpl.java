package com.oatkachenko.services.impl;

import com.oatkachenko.model.dao.TaskDao;
import com.oatkachenko.model.entity.Task;
import com.oatkachenko.model.entity.User;
import com.oatkachenko.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Home on 21.03.2016.
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskDao taskDao;

    @Override
    public Task getById(long id) {
        return taskDao.getById(id);
    }

    @Override
    public List<Task> getTasksByCategoryId(Long id) {
        return taskDao.getTasksByCategoryId(id);
    }

    @Override
    public Task save(Task task) {
        return taskDao.save(task);
    }

    @Override
    public Task update(Task task) {
        return taskDao.update(task);
    }

    @Override
    public boolean delete(Task task) {
        return false;
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public boolean addUserAsFreelancer(long userId, Long taskId) {
        return taskDao.addUserAsFreelancer(userId, taskId);
    }

    @Override
    public Set<User> getFreelancersByTask(long taskId) {
        return taskDao.getFreelancersByTask(taskId);
    }

}
