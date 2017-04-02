package spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */

@RestController
@RequestMapping("api/userTransaction")
public class UserTransactionsController extends AppController{

    @PostMapping("/sendMoney")
    public String sendMoney(){
        return "Sti";
    }

    @PostMapping("/removeMoney")
    public String removeMoney(){
        return "Test";
    }

    @PostMapping("/depositMoney")
    public String depositMoney(){
        return "String";
    }

}