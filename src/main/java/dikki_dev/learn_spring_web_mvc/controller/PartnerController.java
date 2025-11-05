package dikki_dev.learn_spring_web_mvc.controller;

import dikki_dev.learn_spring_web_mvc.model.Partner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PartnerController {

    // Contoh Controller yang tidak perlu Annotation "@ModelAttribute", "@RequestBoddy" atau yang lainnya
    // Karena sudah menggunakan "Custom Argument Resolver"
    @GetMapping(
            path = "/partner/current"
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String getCurrentPartner(Partner partner){ // Parameternya langsung bisa tipe data dari "Partner" nya
        return partner.getId() + ": " + partner.getName();
    }
}
