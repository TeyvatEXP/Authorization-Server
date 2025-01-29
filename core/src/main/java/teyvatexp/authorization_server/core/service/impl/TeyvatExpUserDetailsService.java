package teyvatexp.authorization_server.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import teyvatexp.authorization_server.core.security.TeyvatEXPUserDetails;
import teyvatexp.authorization_server.storage.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class TeyvatExpUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new TeyvatEXPUserDetails(userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email)));
    }
}
