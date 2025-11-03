package dikki_dev.learn_spring_web_mvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller // Tambahkan "@Controller" Annotation agar menandai Class ini menjadi Controller (otomatis sudah menjadi BEAN / Component)
public class HelloController {

    // Akses "localhost:yourPort/hello" untuk tes ini
    @RequestMapping(path = "/hello") // Tambahkan "@RequestMapping" Annotation untuk menjadikan method sebagai Endpoint dengan "path" paramnya
    public void helloWorld(HttpServletResponse response) throws IOException{
        response.getWriter().println("Hello World");
    }
}
