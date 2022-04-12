package com.example.eventApp.config;

import com.example.eventApp.model.entity.User;
import com.example.eventApp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User pawel = new User(
                    1L,
                    "Paweł",
                    "Górski",
                    "pawel.gorski",
                    "password");
            User zenon = new User(2L,
                    "Zenon",
                    "Kowalski",
                    "zenon.kowalski",
                    "password");
            User kazik = new User(3L,
                    "Kazimierz",
                    "Wielki",
                    "kazimierz.wielki",
                    "password");
            User kuba = new User(4L,
                    "Jakub",
                    "Nowak",
                    "jakub.nowak",
                    "password");

            repository.saveAll(List.of(pawel, zenon, kazik, kuba));
        };


    }
}
