package ru.romanchev.life_is_a_sport.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.romanchev.life_is_a_sport.user.User;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode("password"));
        user.setPhoneNumber("+79876543457");
        return user;
    }
}
