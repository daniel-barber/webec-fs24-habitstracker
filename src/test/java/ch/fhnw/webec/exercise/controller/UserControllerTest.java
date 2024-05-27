package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Test
    void testLoginRedirect(){
        UserController userController = new UserController(mock(UserService.class));
        Authentication authentication = mock(Authentication.class);

        when(authentication.isAuthenticated()).thenReturn(true);

        //Copilot corrected the following line of code
        String result = userController.login(authentication, Optional.empty(), mock(Model.class));

        assertEquals("redirect:/", result);

    }
@Test
    void testShowLoginPageWhenNotAuthenticated() {
        UserController userController = new UserController(mock(UserService.class));
        Authentication authentication = mock(Authentication.class);
        when(authentication.isAuthenticated()).thenReturn(false);


        String result = userController.login(authentication, Optional.of("error"), mock(Model.class));

        assertEquals("login/login", result);
    }


}
