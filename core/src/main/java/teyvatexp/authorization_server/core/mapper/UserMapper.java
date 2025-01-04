package teyvatexp.authorization_server.core.mapper;

import org.mapstruct.Mapper;
import teyvatexp.authorization_server.api.dto.UserDTO;
import teyvatexp.authorization_server.dto.User;
import teyvatexp.authorization_server.storage.entity.UserEntity;

@Mapper
public interface UserMapper {

    User mapToDTO(UserEntity entity);

    UserEntity mapToEntity(UserDTO user);

    UserEntity mapFromDTO(UserDTO userDTO);
}
