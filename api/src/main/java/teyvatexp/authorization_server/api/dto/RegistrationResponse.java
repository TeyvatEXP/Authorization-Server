package teyvatexp.authorization_server.api.dto;

public record RegistrationResponse(
        long id,
        String email,
        String username
) {}
