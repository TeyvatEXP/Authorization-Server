package teyvatexp.authorization_server.core.service;

import teyvatexp.authorization_server.api.dto.UserDTO;
import teyvatexp.authorization_server.dto.User;

public interface UserService {

    User createUser(UserDTO user);
}
