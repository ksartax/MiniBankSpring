package java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.model.User;

/**
 * Created by Damian Stępniak on 31.03.2017.
 */

@RestController
public class AppController {



    @GetMapping("/customers")
    public User getUser(){
        User a = new User();
        a.setLastName("Dmaina");
        return a;
    }


}