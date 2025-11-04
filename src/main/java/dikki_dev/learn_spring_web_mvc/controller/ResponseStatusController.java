package dikki_dev.learn_spring_web_mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ResponseStatusController {

    @DeleteMapping(path = "/products/{productId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@PathVariable("productId") Integer productId){
        // Return disini akan void, karena akan mengikuti @ResponseStatus jika berhasil
    }
}
