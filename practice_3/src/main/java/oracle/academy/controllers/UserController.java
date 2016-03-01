package oracle.academy.controllers;


import oracle.academy.model.Role;
import oracle.academy.model.User;
import oracle.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Oleg on 15.02.2016.
 */
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView loadMainPage() {
        System.out.println("я тут!!!!");
        return new ModelAndView("index", "users", userService.getAll());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView getUserForm() {
        return new ModelAndView("addUser");
    }


    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam(value = "firstname", required = true) String firstname,
                                @RequestParam(value = "lastname", required = true) String lastname,
                                @RequestParam(value = "age", required = true) int age,
                                @RequestParam(value = "role", required = true) String role) {
        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setAge(age);
        user.setRole(Role.valueOf(role));
        userService.create(user);
        return new ModelAndView("redirect:/users");
    }
}