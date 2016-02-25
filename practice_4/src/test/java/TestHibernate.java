
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.org.oa.oatkachenko.model.Role;
import ua.org.oa.oatkachenko.model.User;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appContext.xml")
public class TestHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void testCreate() {
        User user = new User();
        user.setDateOfBirth(new Date());
        user.setEmail("create@gmail.com");
        user.setRole(Role.USER);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close(); /*Не обязательно*/
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setDateOfBirth(new Date());
        user.setEmail("update@gmail.com");
        user.setRole(Role.USER);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();

        user.setRole(Role.ADMIN);

        transaction = session.beginTransaction();
        //session.update();
        session.saveOrUpdate(user);
        transaction.commit();

        session.close(); /*Не обязательно*/
    }

    @Test
    public void testRead(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(User.class, 1L); /*get реально загрузит объект из БД, если объекта с заданным id нет - вернет null*/
        transaction.commit();

        System.out.println(user.getEmail());

        transaction = session.beginTransaction();
        /* load создаст объект proxy, в котором будет хранится только поле id, после обращению к любому другому полю хибер попытается его загрузить*/
        /* если объекта нет в баззе, вылитит ObjectNotFoundException*/
        User user2 = (User) session.load(User.class, 100L);
        transaction.commit();

        System.out.println(user2.getEmail());
    }

    @Test
    public void testDelete(){
        User user = new User();
        user.setId(1L);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();

        session.close();


    }




}
