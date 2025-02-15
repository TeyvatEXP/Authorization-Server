package teyvatexp.authorization_server.core.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import teyvatexp.authorization_server.storage.entity.UserEntity;

import java.util.Collection;
import java.util.Collections;

@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public class TeyvatEXPUserDetails implements UserDetails {

    private final UserEntity userEntity;

    @JsonCreator
    public TeyvatEXPUserDetails(@JsonProperty("userEntity") UserEntity userEntity) {
        this.userEntity = userEntity;
    }

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
