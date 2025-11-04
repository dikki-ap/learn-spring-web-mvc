package dikki_dev.learn_spring_web_mvc.controller;

import dikki_dev.learn_spring_web_mvc.model.CreatePersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    @PostMapping(path = "/create/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    // Binding Model dari banyaknya @RequestParam ke suatu Class Model dengan "@ModelAttribute" Annotation
    public String createPerson(@ModelAttribute CreatePersonRequest request){
        return new StringBuilder().append("Succcess create person ")
                .append(request.getFirstName()).append(" ")
                .append(request.getLastName()).append(" ")
                .append(request.getEmail()).append(" ")
                .append(request.getPhone()).append(" ")
                .append("with address").append(" ")
                .append(request.getAddress().getCountry()).append(" ")
                .append(request.getAddress().getProvince()).append(" ")
                .toString();
    }

    @PostMapping(
            path = "/api/create/person",
            consumes = MediaType.APPLICATION_JSON_VALUE, // Requestnya sebagai JSON
            produces = MediaType.APPLICATION_JSON_VALUE // Return ResponseBody juga JSON)
    @ResponseBody
    public CreatePersonRequest createPersonApi(@RequestBody CreatePersonRequest request){
        return request; // Otomatis akan return sebagai JSON karena sudah terintegrasi Spring dengan Jackson
    }
}
