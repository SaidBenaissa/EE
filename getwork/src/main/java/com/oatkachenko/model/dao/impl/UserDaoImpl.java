package com.oatkachenko.model.dao.impl;

import com.oatkachenko.model.dao.UserDao;
import com.oatkachenko.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Oleg on 13.03.2016.
 */

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User create(User user) {
        currentSession().save(user);
        return user;
    }

    @Override
    @Transactional
    public User getById(long id) {
        return (User) currentSession().get(User.class, id);
    }

    @Override
    public User getByUsername(String username) {
        return (User) currentSession().
                createCriteria(User.class).
                add(Restrictions.eq("username", username)).uniqueResult();
    }

    @Override
    public User getByEmail(String email) {
        return (User) currentSession().
                createCriteria(User.class).
                add(Restrictions.eq("email", email)).uniqueResult();
    }

    @Override
    public User update(User user) {
        currentSession().saveOrUpdate(user);
        System.out.println(user);
        return user;
    }

    @Override
    public boolean delete(User user) {
        currentSession().delete(user);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {

        return currentSession().createCriteria(User.class).list();
    }

    @Override
    public User checkVisit(User user) {
        User byId = getById(user.getId());
        byId.setLastseen(new Date(Calendar.getInstance().getTimeInMillis()));
        return byId;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
}
