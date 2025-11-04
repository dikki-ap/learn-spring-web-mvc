package dikki_dev.learn_spring_web_mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @PostMapping(
            path = "/auth/login",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    // Menggunakan "ResponseEntity<T>" untuk @ResponseBody nya dan juga bisa mengembalikan @ResponseStatus sekaligus untuk HTTPStatusCode
    public ResponseEntity<String> login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ){
        if(username.equals("Dikki") && password.equals("123")){
            // "Authenticated" menjadi Response Body, dan mengembalikan @ResponseStatus juga
            return new ResponseEntity<>("Authenticated",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Unauthorized",HttpStatus.UNAUTHORIZED);
        }
    }
}
