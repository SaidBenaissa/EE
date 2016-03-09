package oracle.academy.model.dao.impl;

import oracle.academy.model.User;
import oracle.academy.model.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

/**
 * Created by Oleg on 29.02.2016.
 */
@Repository
@Transactional
public class UserDaoDBImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        Query query = sessionFactory.getCurrentSession().
                createQuery("from User where id=:id");
        query.setParameter("id", id);
        return (User) query.uniqueResult();
    }

    @Override
    public boolean delete(User user) {
        if (nonNull(user)) {
            sessionFactory.getCurrentSession().
                    createQuery("delete User where id=:id").
                    setParameter("id", user.getId()).
                    executeUpdate();
        }
        return true;
    }

    @Override
    public User update(User user) {
        if (nonNull(user)){
            System.out.println(user);
            sessionFactory.getCurrentSession().
                    createQuery("update User set firstName=:fname,lastName=:lname,age=:age").
                    setParameter("fname",user.getFirstName()).
                    setParameter("lname",user.getLastName()).
                    setParameter("age",user.getAge()).
                    executeUpdate();
        }
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(User.class).list();
    }
}
