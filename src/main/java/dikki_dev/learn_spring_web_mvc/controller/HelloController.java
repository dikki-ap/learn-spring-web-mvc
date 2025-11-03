package dikki_dev.learn_spring_web_mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Objects;

@Controller // Tambahkan "@Controller" Annotation agar menandai Class ini menjadi Controller (otomatis sudah menjadi BEAN / Component)
public class HelloController {

    // Akses "http://localhost:yourPort/hello" untuk tes ini
    // Akses http://localhost:9090/hello?name="Dikki" untuk test ini dengan request parameter
    @RequestMapping(path = "/hello") // Tambahkan "@RequestMapping" Annotation untuk menjadikan method sebagai Endpoint dengan "path" paramnya
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String name = request.getParameter("name");

        if(Objects.isNull(name)){
            name = "Guest";
        }
        response.getWriter().println("Hello " + name);
    }
}
