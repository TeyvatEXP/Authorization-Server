package teyvatexp.authorization_server.core.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import teyvatexp.authorization_server.api.dto.UserDTO;
import teyvatexp.authorization_server.core.mapper.UserMapper;
import teyvatexp.authorization_server.core.service.UserService;
import teyvatexp.authorization_server.dto.User;
import teyvatexp.authorization_server.storage.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    @Transactional
    public User createUser(UserDTO user) {
        return mapper.mapToDTO(repository.save(mapper.mapToEntity(user)));
    }
}
