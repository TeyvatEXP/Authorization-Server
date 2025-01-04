package teyvatexp.authorization_server.dto;

import lombok.Data;

@Data
public class User {
    private long id;
    private String email;
    private String login;
    private String password;
}
