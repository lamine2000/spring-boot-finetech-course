package com.spring.demo.initDB;

import com.spring.demo.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserInit implements ApplicationListener<ApplicationReadyEvent> {

    UserRepository userRepository;

    public UserInit(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("Application Ready!");

        //User user1 = new User("Bamba", "Dieng");
        //userRepository.save(user1);
        //userRepository.findById(4L).ifPresent(System.out::println);
        //userRepository.findUserByLogin("Gallo").ifPresent(System.out::println);
        //userRepository.deleteAllById(Arrays.asList(2L, 3L));

        userRepository.findIt("Dieng").ifPresent(System.out::println);


    }
}
