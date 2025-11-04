package dikki_dev.learn_spring_web_mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dikki_dev.learn_spring_web_mvc.model.HelloRequest;
import dikki_dev.learn_spring_web_mvc.model.HelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BodyController {

    // ObjectMapper class dapat digunakan di Spring Web MVC
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(
            path = "/body/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE, // Beri tahu bahwa request berbentuk JSON
            produces = MediaType.APPLICATION_JSON_VALUE  // Dan response berbentuk JSON
    )
    @ResponseBody
    // Gunakan "@RequestBody" Annotation
    public String getBody(@RequestBody String requestBody) throws JsonProcessingException{

        // Membaca requestBody sebagai bentuk Model dari "HelloRequest" Class
        HelloRequest request = objectMapper.readValue(requestBody, HelloRequest.class);

        // Set Response sesuai yang diinginkan
        HelloResponse response = new HelloResponse();
        response.setHello("Hello " + request.getName());

        // Return kembali response nya menjadi JSON
        return objectMapper.writeValueAsString(response);
    }
}
