package dikki_dev.learn_spring_web_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping(path = "/header/token")
    @ResponseBody
    // Menggunakan @RequestHeader, bukan @RequestParam, sama seperti sebelumnya, bisa menggunakan Converter juga
    public String getToken(@RequestHeader(name = "X-TOKEN")String token){
        if (token.equals("Dikki")){
            return "Authorized";
        }else{
            return "Unauthorized";
        }
    }
}
