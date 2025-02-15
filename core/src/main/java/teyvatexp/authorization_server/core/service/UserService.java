package teyvatexp.authorization_server.core.service;

import teyvatexp.authorization_server.api.dto.RegistrationResponse;
import teyvatexp.authorization_server.api.dto.UserDTO;

public interface UserService {

    RegistrationResponse createUser(UserDTO user);
}
