package com.spring.demo.initDB;

import com.spring.demo.model.Country;
import com.spring.demo.model.User;
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

        //creatio and insertion of records into the database
        Country france = new Country("france", "", "fr", "euro");
        Country senegal = new Country("senegal", "pays de la Teranga", "sn", "franc cfa");

        User user1 = new User("Bamba", "Dieng", senegal);
        User user3 = new User("Lamine", "Gueye", senegal);
        User user2 = new User("Alex", "Corenthin", france);

        //countries before users (non nullable constraint)
        this.countryService.createAll(List.of(france, senegal));
        this.userService.createAll(List.of(user1, user2, user3));

        //functional programming: creating own consumer to display a list of users
        Consumer<List<User>> printUsers = users -> {users.forEach(System.out::println);};

        //display all the users from senegal
        this.userService.findByCountryName("senegal").ifPresent(printUsers);
        //display all the users with password 'Dieng'
        this.userService.findByPasswordCustomQuery("Dieng").ifPresent(System.out::println);
    }
}
