package teyvatexp.authorization_server.core.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import teyvatexp.authorization_server.api.dto.RegistrationResponse;
import teyvatexp.authorization_server.api.dto.UserDTO;
import teyvatexp.authorization_server.core.mapper.UserMapper;
import teyvatexp.authorization_server.core.service.UserService;
import teyvatexp.authorization_server.storage.entity.UserEntity;
import teyvatexp.authorization_server.storage.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    @Transactional
    public RegistrationResponse createUser(UserDTO user) {
        UserEntity saved = repository.save(mapper.mapToEntity(user));
        return new RegistrationResponse(saved.getId(), saved.getEmail(), saved.getUsername());
    }
}
