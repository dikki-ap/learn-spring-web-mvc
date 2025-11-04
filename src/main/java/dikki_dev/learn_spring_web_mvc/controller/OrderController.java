package dikki_dev.learn_spring_web_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    // Menggunakan "@PathVariable" Annotation untuk mengambil nilai sesuai path URL secara dinamis
    @GetMapping(path = "/orders/{orderId}/products/{productId}")
    @ResponseBody
    public String order(
            @PathVariable("orderId") String orderId,
            @PathVariable("productId") String productId
    ){
        return "Order: " + orderId + ", Product: " + productId;
    }
}
