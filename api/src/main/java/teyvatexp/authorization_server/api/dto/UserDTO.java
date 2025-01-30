package teyvatexp.authorization_server.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "Username should contain only latin characters and numbers.")
    private String username;
    @Email(message = "Please enter valid email.")
    private String email;
    @NotNull(message = "Password must not be null.")
    @Size(min = 8, message = "Password must be large than 8.")
    @Pattern(regexp = "^[A-Za-z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]*$",
            message = "Only alphanumeric characters and special symbols are allowed.")
    private String password;
}
