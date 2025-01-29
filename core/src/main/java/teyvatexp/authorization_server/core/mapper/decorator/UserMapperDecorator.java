package teyvatexp.authorization_server.core.mapper.decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import teyvatexp.authorization_server.api.dto.UserDTO;
import teyvatexp.authorization_server.core.mapper.UserMapper;
import teyvatexp.authorization_server.dto.User;
import teyvatexp.authorization_server.storage.entity.Role;
import teyvatexp.authorization_server.storage.entity.UserEntity;

@Component
public class UserMapperDecorator implements UserMapper {

    @Autowired
    private UserMapper delegate;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserEntity mapToEntity(UserDTO user) {
        UserEntity userEntity = delegate.mapToEntity(user);
        userEntity.setPassword(encoder.encode(user.getPassword()));
        userEntity.setRole(Role.USER);
        return userEntity;
    }

    @Override
    public User mapToDTO(UserEntity entity) {
        return delegate.mapToDTO(entity);
    }

    @Override
    public UserEntity mapFromDTO(UserDTO userDTO) {
        return delegate.mapFromDTO(userDTO);
    }
}

