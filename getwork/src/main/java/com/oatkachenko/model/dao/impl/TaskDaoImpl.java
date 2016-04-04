package com.oatkachenko.model.dao.impl;

import com.oatkachenko.model.dao.TaskDao;
import com.oatkachenko.model.entity.Task;
import com.oatkachenko.model.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 *
 */
@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Task save(Task task) {
        currentSession().save(task);
        return task;
    }

    @Override
    public Task update(Task task) {
        currentSession().update(task);
        return task;
    }

    @Override
    public Task getById(Long id) {
        return (Task) currentSession().get(Task.class, id);
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Task> getTasksByCategoryId(Long id) {
        Query query = currentSession().createQuery("from Task where category_id = :id");
        query.setParameter("id", String.valueOf(id));
        return query.list();
    }


    @Override
    public boolean addUserAsFreelancer(long userId, long taskId) {
        Task byId = getById(taskId);
        User userById = (User) currentSession().get(User.class, userId);
        Set<User> users = byId.getFreelancers();
        if (users.contains(userById)) {
            return false;
        }
        users.add(userById);
        return true;
    }

    @Override
    public Set<User> getFreelancersByTask(long taskId) {
        Task task = getById(taskId);
        return task.getFreelancers();
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
}