package dikki_dev.learn_spring_web_mvc.controller;

import dikki_dev.learn_spring_web_mvc.services.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Objects;

@Controller // Tambahkan "@Controller" Annotation agar menandai Class ini menjadi Controller (otomatis sudah menjadi BEAN / Component)
public class HelloController {

    @Autowired
    private HelloService helloService;

    // Akses "http://localhost:yourPort/hello" untuk tes ini
    // Akses http://localhost:9090/hello?name="Dikki" untuk test ini dengan request parameter
    // Tambahkan "@RequestMapping" Annotation untuk menjadikan method sebagai Endpoint dengan "path" paramnya
    // Tambahkan "method" dengan "RequestMethod.GET", jika dipanggil menggunakan yang lain akan return 405 Not Allowed
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String name = request.getParameter("name");

        String responseBody = helloService.hello(name);

        response.getWriter().println(responseBody);
    }
}
