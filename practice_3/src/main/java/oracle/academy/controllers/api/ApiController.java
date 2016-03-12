package oracle.academy.controllers.api;

import oracle.academy.model.User;
import oracle.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Home on 12.03.2016.
 */
@Controller
public class ApiController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/api/users/get/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/api/users/get/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}
