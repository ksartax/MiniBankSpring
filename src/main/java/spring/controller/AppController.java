package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import spring.model.User;
import spring.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.*;
import java.util.*;

/**
 * Created by Damian Stępniak on 17.03.2017.
 */

@RestController
public class AppController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/customers")
    public java.util.List<User> getUser(){
        return usersService.getAll();
    }


}
