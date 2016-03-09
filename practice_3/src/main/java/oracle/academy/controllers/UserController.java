package oracle.academy.controllers;


import oracle.academy.model.Role;
import oracle.academy.model.User;
import oracle.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Oleg on 15.02.2016.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView loadMainPage() {
        return new ModelAndView("index", "users", userService.getAll());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView getUserForm() {
        return new ModelAndView("addUser");
    }


    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam(value = "firstname", required = true) String firstname,
                                @RequestParam(value = "lastname", required = true) String lastname,
                                @RequestParam(value = "age", required = true) int age,
                                @RequestParam(value = "role", required = true) String role) {
        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setAge(age);
        user.setRole(Role.valueOf(role));
        User user1 = userService.create(user);
        System.out.println("user:");
        System.out.println(user1);
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable(value = "id") Long id) {
        System.out.println(userService.getById(id));
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        userService.delete(userService.getById(id));
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") Long id) {
        return new ModelAndView("editUser", "user", userService.getById(id));
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView saveEditedUser(@RequestParam(value = "firstname", required = true) String firstname,
                                       @RequestParam(value = "lastname", required = true) String lastname,
                                       @RequestParam(value = "age", required = true) int age,
                                       @RequestParam(value = "role", required = true) String role,
                                       @RequestParam(value = "id") Long id) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setAge(age);
        user.setRole(Role.valueOf(role));
        userService.update(user);
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/getJson", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllByJson(){
        return userService.getAll();
    }
}