package oracle.academy;

import oracle.academy.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Home on 16.02.2016.
 */
public class UserDaoImpl implements UserDao {
    private static UserDaoImpl instance = null;
    private Map<Long, User> userMap = new HashMap<>();
    private long id = 0;

    private UserDaoImpl() {

    }

    @Override
    public User create(User user) {
        user.setId(++id);
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }

    @Override
    public boolean delete(User user) {
        boolean isDeleted = false;
        if (userMap.containsKey(user.getId())) {
            userMap.remove(user.getId());
            isDeleted = true;
        }
        return isDeleted;
    }

    @Override
    public User update(User user) {
        return userMap.put(user.getId(), user);
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        userMap.forEach((aLong, user) -> {
            userList.add(user);
        });
        return userList;
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

}
