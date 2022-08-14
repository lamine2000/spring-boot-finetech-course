package com.spring.demo.service;

import com.spring.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User create(User user);

    public List<User> createAll(Iterable<User> users);

    public Optional<User> findByLogin(String login);

    public Optional<List<User>> findByPasswordCustomQuery(String password);

    public Optional<List<User>> findByCountryName(String name);
}
