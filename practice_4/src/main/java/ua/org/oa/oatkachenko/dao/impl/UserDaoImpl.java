package ua.org.oa.oatkachenko.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.org.oa.oatkachenko.dao.UserDao;

/**
 * Created by Oleg on 17.02.2016.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    SessionFactory sessionFactory;

    public void getName(){
        System.out.println("my name: UserDAO");
    }
}
