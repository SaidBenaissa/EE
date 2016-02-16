package oracle.academy;

import oracle.academy.model.Role;
import oracle.academy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Oleg on 15.02.2016.
 */
@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String getUserForm(ModelMap model) {
        model.addAttribute("message", "Spring in action)))");
        return "addUser";
    }


    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public String addUser(ModelMap model,
                          @RequestParam(value = "firstname", required = true) String firstname,
                          @RequestParam(value = "lastname", required = true) String lastname,
                          @RequestParam(value = "age", required = true) int age,
                          @RequestParam(value = "role", required = true) String role
    ) {
        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setAge(age);
        user.setRole(Role.valueOf(role));
        UserDao dao = UserDaoImpl.getInstance();
        dao.create(user);
        model.put("users",dao.getAll());
        return "index";
    }
}