package com.oatkachenko.services;

import com.oatkachenko.model.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Oleg on 13.03.2016.
 */
public interface UserService {
    User save(User user);
    User getById(long id);
    User getByUsername(String login);
    User getByEmail(String email);
    User update(User user);
    boolean delete(User user);
    List<User> getAll();
    User checkVisit(User user);

}
