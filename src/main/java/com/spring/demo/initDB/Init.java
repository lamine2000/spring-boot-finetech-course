package com.spring.demo.initDB;

import com.spring.demo.model.Country;
import com.spring.demo.model.User;
import com.spring.demo.repository.CountryRepository;
import com.spring.demo.repository.UserRepository;
import com.spring.demo.service.CountryService;
import com.spring.demo.service.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;

@Component
public class Init implements ApplicationListener<ApplicationReadyEvent> {

    final UserService userService;
    final CountryService countryService;

    public Init(UserService userService, CountryService countryService) {
        this.userService = userService;
        this.countryService = countryService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("Application Ready!");

        Country france = new Country("france", "", "fr", "euro");
        Country senegal = new Country("senegal", "pays de la Teranga", "sn", "franc cfa");

        User user1 = new User("Bamba", "Dieng", senegal);
        User user3 = new User("Lamine", "Gueye", senegal);
        User user2 = new User("Alex", "Corenthin", france);

        this.countryService.createAll(List.of(france, senegal));
        this.userService.createAll(List.of(user1, user2, user3));

        Consumer<List<User>> printUsers = users -> {
            for(User user : users)
                System.out.println(user);
        };
        this.userService.findByCountryName("senegal").ifPresent(printUsers);
        this.userService.findByPasswordCustomQuery("Dieng").ifPresent(System.out::println);
    }
}
