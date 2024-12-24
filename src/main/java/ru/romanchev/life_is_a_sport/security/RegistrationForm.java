package ru.romanchev.life_is_a_sport.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.romanchev.life_is_a_sport.user.User;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setPhoneNumber(phone);
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
