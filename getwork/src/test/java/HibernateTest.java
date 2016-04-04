import com.oatkachenko.services.TaskService;
import com.oatkachenko.services.UserService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Oleg on 13.03.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appContext.xml")
public class HibernateTest {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @Test
    public void ConnectionTest() {
        assertNotNull(sessionFactory);
    }

}
