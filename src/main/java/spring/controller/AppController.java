package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.model.Address_User;
import spring.model.User;
import spring.service.UsersService;

import java.awt.*;
import java.util.*;

/**
 * Created by Damian Stępniak on 17.03.2017.
 */

@RestController
@RequestMapping("api/user")
public class AppController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/customers")
    public java.util.List<User> getUser(){
        return usersService.getAll();
    }

    @PostMapping("/add")
    public String save(@RequestBody String string){
        return string;
    }

}
