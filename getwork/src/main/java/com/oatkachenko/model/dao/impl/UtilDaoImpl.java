package com.oatkachenko.model.dao.impl;

import com.oatkachenko.model.dao.UtilDao;
import com.oatkachenko.model.entity.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Home on 25.03.2016.
 */
@Repository
public class UtilDaoImpl implements UtilDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> getAllCategories() {
        return sessionFactory.getCurrentSession().
                createCriteria(Category.class).list();
    }
}