package dikki_dev.learn_spring_web_mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private CreateAddressRequest address;
}
