package teyvatexp.authorization_server.core.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.security.core.GrantedAuthority;
import teyvatexp.authorization_server.storage.entity.UserEntity;

import java.util.Collection;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class TeyvatEXPUserDetailsMixin {

    @JsonCreator
    public TeyvatEXPUserDetailsMixin(@JsonProperty("userEntity") UserEntity userEntity) {
    }

    @JsonProperty(value = "authorities", access = JsonProperty.Access.READ_ONLY)
    abstract Collection<? extends GrantedAuthority> getAuthorities();

    @JsonProperty(value = "username", access = JsonProperty.Access.READ_ONLY)
    abstract String getUsername();

    @JsonProperty(value = "password", access = JsonProperty.Access.READ_ONLY)
    abstract String getPassword();

    @JsonProperty(value = "isAccountNonExpired", access = JsonProperty.Access.READ_ONLY)
    abstract boolean isAccountNonExpired();

    @JsonProperty(value = "isAccountNonLocked", access = JsonProperty.Access.READ_ONLY)
    abstract boolean isAccountNonLocked();

    @JsonProperty(value = "isCredentialsNonExpired", access = JsonProperty.Access.READ_ONLY)
    abstract boolean isCredentialsNonExpired();

    @JsonProperty(value = "isEnabled", access = JsonProperty.Access.READ_ONLY)
    abstract boolean isEnabled();
}
