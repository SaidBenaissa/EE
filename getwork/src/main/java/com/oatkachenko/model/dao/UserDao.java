package com.oatkachenko.model.dao;

import com.oatkachenko.model.entity.User;

import java.sql.Date;
import java.util.List;

/**
 * Created by Oleg on 13.03.2016.
 */
public interface UserDao {
    User create(User user);
    User getById(long id);
    User getByUsername(String login);
    User getByEmail(String email);
    User update(User user);
    boolean delete(User user);
    List getAll();
    User checkVisit(User user);

}
