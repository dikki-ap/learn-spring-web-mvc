package dikki_dev.learn_spring_web_mvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

    // Menambahkan "MediaType" sesuai dengan "Request Content Type"
    // Biasanya saat submit data form kita meminta user untuk mengirimkan data "application/x-www-form-urlencoded"
    @PostMapping(path = "/form/hello", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String hello(@RequestParam(name = "name")String name){
        return "Hello " + name;
    }


    @PostMapping(
            path = "/form/helloHtml",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE // Memberitahukan HttpResponseBody agar returnnya dalam bentuk HTML
    )
    @ResponseBody
    public String helloHtml(@RequestParam(name = "name")String name){
        return """
                <html>
                    <body>
                        <h1>Hello $name</h1>
                    </body>
                </html>
                """.replace("$name", name); // Replace "$name" dengan @RequestParam
    }
}
