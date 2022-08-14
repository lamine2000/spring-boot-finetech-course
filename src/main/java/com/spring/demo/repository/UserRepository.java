package com.spring.demo.repository;

import com.spring.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    @Query("select u from User u where u.password = ?1")
    Optional<List<User>> findIt(String password);

    //we are performing a join with nested queries to find a user by it's country's name (instead of the id of the country)
    @Query("select u from User u where u.country = (select c from Country c where c.name = ?1)")
    Optional<List<User>> findByCountryName(String name); //tries to perform un join
}
