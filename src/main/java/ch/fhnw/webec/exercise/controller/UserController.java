package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.User;
import ch.fhnw.webec.exercise.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.Set;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Authentication authentication, @RequestParam("error") Optional<String> error, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/";
        } else {
            model.addAttribute("hasLoginError", error.isPresent());

            return "login/login";
        }
    }

    @RequestMapping(path = "/signup", method = RequestMethod.GET)
    public String register() {
        return "login/signup";
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult bindingResult, Model model) {
        if (this.userService.usernameAlreadyExists(user.getUsername())) {
            bindingResult.addError(new FieldError("user", "username", "Username already exists"));
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);

            return "login/signup";
        } else {
            this.userService.addUser(user.getUsername(), user.getPassword(), Set.of("ROLE_USER"));

            return "redirect:/login";
        }
    }
}
