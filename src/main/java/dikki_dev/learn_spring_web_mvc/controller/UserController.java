package dikki_dev.learn_spring_web_mvc.controller;

import dikki_dev.learn_spring_web_mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserController {

    @GetMapping(path = "/user/current")
    @ResponseBody
    // Mengambil nilai Session dengan "@SessionAttribute" Annotation
    public String getCurrentUser(@SessionAttribute(name = "user")User user){
        return "Hello " + user.getUsername();
    }
}
