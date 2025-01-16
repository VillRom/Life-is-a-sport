package ru.romanchev.life_is_a_sport.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.romanchev.life_is_a_sport.user.User;
import ru.romanchev.life_is_a_sport.user.UserRepository;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws Exception {
        return http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/events", "/users", "/events/**", "/users/**").hasRole("USER"))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/**").permitAll())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login"))
                .logout(logout -> logout
                        .logoutSuccessUrl("/"))
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**"))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository repo) {
        return username -> {
            User user = repo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("Пользователь '" + username + "' не найден");
        };
    }

    @Bean
    @Primary
    public AuthenticationManagerBuilder authManager(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        return auth;
    }
}
