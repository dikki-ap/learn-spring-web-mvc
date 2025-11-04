package dikki_dev.learn_spring_web_mvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
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
            @RequestParam(name = "password") String password,
            HttpServletResponse response // Tambahkan ini untuk membaca cookie
    ){
        if(username.equals("Dikki") && password.equals("123")){
            // Membuat sebuah Cookie ketika login sukses
            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");

            // Menambahkan Cookie ke HttpServletResponse
            response.addCookie(cookie);

            // "Authenticated" menjadi Response Body, dan mengembalikan @ResponseStatus juga
            return new ResponseEntity<>("Authenticated",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Unauthorized",HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "/auth/user")
    // Mengambil nilai Cookie dari Request tanpa HttpServletResponse yaitu menggunakan "@CookieValue('key')" Annotation
    public ResponseEntity<String> getUser(@CookieValue("username") String username){
        return new ResponseEntity<>("Hello " + username, HttpStatus.OK);
    }
}
