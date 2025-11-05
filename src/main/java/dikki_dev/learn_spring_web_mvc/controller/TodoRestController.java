package dikki_dev.learn_spring_web_mvc.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


// "@RestController" Annotation adalah gabungan antara "@Controller" dan "@ResponseBody", otomatis returnnya akan menggunakan "@ResponseBody"
@RestController
public class TodoRestController {

    private List<String> todos = new ArrayList<>();

    @PostMapping(
            path = "/todos",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<String> addTodo(@RequestParam("todo") String todo){
        todos.add(todo);
        return todos;
    }

    @GetMapping(
            path = "/todos",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<String> getTodo(){
        return todos;
    }
}
