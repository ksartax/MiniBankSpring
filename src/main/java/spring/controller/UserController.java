package spring.controller;

import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.model.User;
import spring.service.UsersService;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */

@RestController
@RequestMapping("api/user")
public class UserController extends AppController{

    @Autowired
    private UsersService usersService;

    @PostMapping("/list")
    public java.util.List<User> getUser(){
        return usersService.getAll();
    }

    @PostMapping("/register")
    public String register(@RequestBody String string){
        return string;
    }

    @PostMapping("/login")
    public String login(@RequestBody String string){
        return string;
    }

    @PostMapping("/profile")
    public String profile(@RequestBody String string){
        return string;
    }

    @PostMapping("/resetPassword")
    public String resetPassword(){
        return "String";
    }

}
