package oracle.academy.dao.impl;

import oracle.academy.dao.UserDao;
import oracle.academy.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 29.02.2016.
 */
@Repository
public class UserDaoDBImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User create(User user) {


        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {

        Session sess = null;
        List<User> users = new ArrayList<>();

        try {
            sess = sessionFactory.getCurrentSession();
            Query q = sess.createQuery("from User");

            q.list().forEach(userProxy -> {
                users.add((User) userProxy);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
