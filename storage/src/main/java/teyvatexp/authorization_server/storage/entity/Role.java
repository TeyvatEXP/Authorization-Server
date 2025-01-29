package teyvatexp.authorization_server.storage.entity;

import lombok.Getter;

public enum Role {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN"),
    ANONYMOUS("ROLE_ANONYMOUS");

    @Getter
    private final String name;

    Role(String name) {
        this.name = name;
    }
}
