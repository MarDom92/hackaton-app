package com.example.eventApp.config;

import com.example.eventApp.model.entity.User;
import com.example.eventApp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            User pawel = new User(
                    1L,
                    "Paweł",
                    "Górski",
                    "pawel.gorski",
                    passwordEncoder.encode("password"));
            User zenon = new User(2L,
                    "Zenon",
                    "Kowalski",
                    "zenon.kowalski",
                    passwordEncoder.encode("password"));
            User kazik = new User(3L,
                    "Kazimierz",
                    "Wielki",
                    "kazimierz.wielki",
                    passwordEncoder.encode("password"));
            User kuba = new User(4L,
                    "Jakub",
                    "Nowak",
                    "jakub.nowak",
                    passwordEncoder.encode("password"));
            User cba = new User(5L,
                    "c",
                    "b",
                    "a",
                    passwordEncoder.encode("a"));

            repository.saveAll(List.of(pawel, zenon, kazik, kuba, cba));
        };


    }
}
