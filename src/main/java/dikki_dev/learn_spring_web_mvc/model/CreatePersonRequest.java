package dikki_dev.learn_spring_web_mvc.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {
    @NotBlank
    private String firstName;

    private String lastName;

    @NotBlank
    private String email;

    private String phone;
    private CreateAddressRequest address;
}
