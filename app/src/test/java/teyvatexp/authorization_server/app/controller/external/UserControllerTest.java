package teyvatexp.authorization_server.app.controller.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import teyvatexp.authorization_server.api.dto.RegistrationResponse;
import teyvatexp.authorization_server.api.dto.UserDTO;
import teyvatexp.authorization_server.core.service.UserService;
import teyvatexp.authorization_server.core.util.GlobalExceptionHandler;

import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        UserController controller = new UserController(userService);
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    void registerUser_onSuccess_shouldReturnCreated() throws Exception {
        final var username = "username";
        final var email = "email@email.com";
        final var password = "password1!";
        final var request = new UserDTO(username, email, password);
        final var response = new RegistrationResponse(1, email, username);

        when(userService.createUser(request)).thenReturn(response);

        mockMvc.perform(post("/api/v1/authorization_server/users")
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.username").value(username));
    }

    private static Stream<Arguments> getTestCases() {
        return Stream.of(
                Arguments.of("user   name", "email@email.com", "password1!"),
                Arguments.of("username", "email", "password1!"));
    }

    @ParameterizedTest
    @MethodSource("getTestCases")
    void registerUser_onValidationFailed_shouldReturnBadRequest(String username, String email, String password) throws Exception {
        final var request = new UserDTO(username, email, password);

        mockMvc.perform(post("/api/v1/authorization_server/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void registerUser_onNullBody_shouldReturnBadRequest() throws Exception {
        final var request = new UserDTO(null, null, null);

        mockMvc.perform(post("/api/v1/authorization_server/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
