package teyvatexp.authorization_server.core.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import teyvatexp.authorization_server.storage.entity.UserEntity;

import java.util.Collection;
import java.util.Collections;

@Getter
@RequiredArgsConstructor
public class TeyvatEXPUserDetails implements UserDetails {

    private final UserEntity userEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final var authority = new SimpleGrantedAuthority(userEntity.getRole().getName());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getEmail();
    }
}
