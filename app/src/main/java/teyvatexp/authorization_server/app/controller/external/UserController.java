package teyvatexp.authorization_server.app.controller.external;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teyvatexp.authorization_server.api.dto.RegistrationResponse;
import teyvatexp.authorization_server.api.dto.UserDTO;
import teyvatexp.authorization_server.core.service.UserService;

@RestController
@RequestMapping("${apiPrefix}/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping
    public RegistrationResponse createUser(@RequestBody @Valid UserDTO user) {
        return userService.createUser(user);
    }
}
