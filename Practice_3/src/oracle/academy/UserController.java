package oracle.academy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Oleg on 15.02.2016.
 */
@Controller
@RequestMapping("/hello")
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String getUserForm(ModelMap model){
        model.addAttribute("message","Spring in action)))");
        return "addUser";
    }

}