package dikki_dev.learn_spring_web_mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloRequest {
    private String name;
}
