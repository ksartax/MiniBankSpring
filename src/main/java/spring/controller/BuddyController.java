package spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */

@RestController
@RequestMapping("/api/user/buddy")
public class BuddyController {

    @PostMapping("/list")
    public String list(){
        return "list";
    }

    @PostMapping("/add")
    public String add(){
        return "add";
    }

    @PostMapping("/remove")
    public String remove(){
        return "Aam";
    }

}
