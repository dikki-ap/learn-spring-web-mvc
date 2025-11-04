package dikki_dev.learn_spring_web_mvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    // Ketika request "date" masuk sebagai String dengan format "yyyy-MM-dd" ke Converter, akan diubah ke dalam bentuk Date otomatis oleh Spring
    @GetMapping(path = "/date")
    public void getDate(@RequestParam(name = "date")Date date, HttpServletResponse response) throws IOException{

        // Hanya saja format response Date nya akan ditentukan seperti yang di atas "yyyyMMdd"
        response.getWriter().println("Date: " + simpleDateFormat.format(date));
    }
}