package com.spring.demo;

import org.springframework.context.annotation.Profile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Profile("dev")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String login;
    String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(){}

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
