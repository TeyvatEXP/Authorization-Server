package teyvatexp.authorization_server.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView checkAuth(@AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) {
        boolean isOAuth2Request = request.getParameter("client_id") != null;

        if (userDetails != null && !isOAuth2Request) {
            return new ModelAndView("redirect:/index.html");
        }

        return new ModelAndView("login");
    }
}
