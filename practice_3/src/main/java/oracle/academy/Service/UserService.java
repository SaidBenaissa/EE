package oracle.academy.service;

import oracle.academy.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Oleg on 29.02.2016.
 */

public interface UserService {
    User create(User user);
    User getById(Long id);
    boolean delete(User user);
    User update(User user);
    List<User> getAll();

}
