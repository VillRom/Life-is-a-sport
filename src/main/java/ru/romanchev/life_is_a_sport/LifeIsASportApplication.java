package ru.romanchev.life_is_a_sport;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.romanchev.life_is_a_sport.category.Category;
import ru.romanchev.life_is_a_sport.category.CategoryRepository;
import ru.romanchev.life_is_a_sport.event.EnumState;
import ru.romanchev.life_is_a_sport.event.Event;
import ru.romanchev.life_is_a_sport.event.EventRepository;
import ru.romanchev.life_is_a_sport.user.User;
import ru.romanchev.life_is_a_sport.user.UserRepository;

@SpringBootApplication
public class LifeIsASportApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeIsASportApplication.class, args);
    }
    @Bean
    public ApplicationRunner dataLoader(UserRepository userRepo, CategoryRepository categRepo,
                                        EventRepository eventRepo, PasswordEncoder encoder) {
        return args -> {
            User user = new User("vill", encoder.encode("password"),
                    "ROLE_ADMIN","+79876543457");
            userRepo.save(user);
            Category category = new Category("Футбол");
            categRepo.save(category);
            eventRepo.save(new Event("Игра 5х5", category, user,
                    false, 15, EnumState.CREATED));
        };
    }
}
