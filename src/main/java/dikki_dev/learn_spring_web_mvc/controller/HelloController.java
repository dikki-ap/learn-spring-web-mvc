package dikki_dev.learn_spring_web_mvc.controller;

import dikki_dev.learn_spring_web_mvc.services.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Controller // Tambahkan "@Controller" Annotation agar menandai Class ini menjadi Controller (otomatis sudah menjadi BEAN / Component)
public class HelloController {

    @Autowired
    private HelloService helloService;

    // Akses "http://localhost:yourPort/hello" untuk tes ini
    // Akses http://localhost:9090/hello?name="Dikki" untuk test ini dengan request parameter
    // Tambahkan "@RequestMapping" Annotation untuk menjadikan method sebagai Endpoint dengan "path" paramnya
    // Tambahkan "method" dengan "RequestMethod.GET", jika dipanggil menggunakan yang lain akan return 405 Not Allowed
    // @RequestMapping(path = "/hello", method = RequestMethod.GET) --> Contoh 1


    // Menggunakan "@RequestParam" Annotation daripada HttpServletRequest (bisa tentukan required, "name", defaultValue, etc)
    @GetMapping(path = "/hello") // --> Contoh 2 sesuai RequestMethodnya
    public void helloWorld(@RequestParam(name = "name", required = false) String name, HttpServletResponse response) throws IOException{
        String responseBody = helloService.hello(name);

        response.getWriter().println(responseBody);
    }

    // Jika menggunakan "Template Engine" returnnya tipe "ModelAndView", kemudian pilih nama "view" nya dengan nama "hello" dan kirimkan datanya menggunakan Map<K, V>
    @GetMapping(path = "/web/hello")
    public ModelAndView hello(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name) {
        return new ModelAndView("hello", Map.of(
                "title", "Belajar View Mustache",
                "name", name
        ));
    }

}
