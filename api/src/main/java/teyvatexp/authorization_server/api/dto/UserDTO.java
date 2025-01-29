package teyvatexp.authorization_server.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import teyvatexp.authorization_server.api.util.Password;

@Data
public class UserDTO {
    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "Username should contain only latin characters and numbers.")
    private String username;
    @Email(message = "Please enter valid email.")
    private String email;
    @Password
    private String password;
}
