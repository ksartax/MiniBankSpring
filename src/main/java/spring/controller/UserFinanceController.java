package spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */

@RestController
@RequestMapping("api/userFinance")
public class UserFinanceController extends AppController{

    @PostMapping("/listDeposit")
    public String listDeposit(){
        return "Test";
    }

    @PostMapping("/listRemove")
    public String listRemove(){
        return "Test";
    }

    @PostMapping("/listFromBankAccountTransaction")
    public String listFromBankAccountTransaction(){
        return "Test";
    }

    @PostMapping("/listToBankAccountTransaction")
    public String toBankAccountTransaction(){
        return "Test";
    }

    @PostMapping("/getStatusMoney")
    public String getStatusMoney(){
        return "String";
    }

}
