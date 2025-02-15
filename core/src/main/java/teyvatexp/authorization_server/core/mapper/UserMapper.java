package teyvatexp.authorization_server.core.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import teyvatexp.authorization_server.api.dto.UserDTO;
import teyvatexp.authorization_server.core.mapper.decorator.UserMapperDecorator;
import teyvatexp.authorization_server.storage.entity.UserEntity;

@Mapper(componentModel = "spring")
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {
    UserEntity mapToEntity(UserDTO user);
    UserEntity mapFromDTO(UserDTO userDTO);
}
