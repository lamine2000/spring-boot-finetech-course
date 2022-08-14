package com.spring.demo.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "country_table")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Nullable //description is not mandatory
    private String description;

    private String code; //Examples: sn, fr
    private String currency;

    //map by the country attribute of User class
    //fetching data in a lazy way: fetching country does not imply fetching it's users
    //all the operations to the Country table are cascaded to the users
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;


    public Country(String name, @Nullable String description, String code, String currency) {
        this.name = name;
        this.description = description;
        this.code = code;
        this.currency = currency;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
