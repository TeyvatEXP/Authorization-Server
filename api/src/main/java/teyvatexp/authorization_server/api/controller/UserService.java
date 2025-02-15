package teyvatexp.authorization_server.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import teyvatexp.authorization_server.api.dto.RegistrationResponse;
import teyvatexp.authorization_server.api.dto.UserDTO;

public interface UserService {
    @PostMapping("${apiPrefix}/users")
    RegistrationResponse register(@RequestBody UserDTO user);
}
