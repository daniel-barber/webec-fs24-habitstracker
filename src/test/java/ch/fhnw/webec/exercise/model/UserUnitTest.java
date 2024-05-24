package ch.fhnw.webec.exercise.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserUnitTest {

    private User user;
    private Validator validator;

    @BeforeEach
    void setUp(){
        Set<String> authorities = new HashSet<>();
        authorities.add("ROLE_USER");
        authorities.add("ROLE_ADMIN");

        user = new User("userTest", "pwTest", authorities);

        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }
    @Test
    public void testAuthorities(){
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        assertEquals(2, authorities.size());
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }
    @Test
    public void testUsername(){
        user = new User("", "password", new HashSet<>());
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }

}
