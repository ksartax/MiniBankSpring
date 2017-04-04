package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.model.Finance_Account_User;
import spring.service.UserFinanceService;

import java.util.Set;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */

@RestController
@RequestMapping("api/user/finance")
public class UserFinanceController extends AppController{

    @Autowired
    private UserFinanceService userFinanceService;

    @PostMapping("/userFinance")
    public ResponseEntity<Finance_Account_User> getUserFinance(){
        return new ResponseEntity<Finance_Account_User>(HttpStatus.OK);
    }

    @PostMapping("/listDeposit")
    public ResponseEntity<Set<Finance_Account_User>> listDeposit(){
        return new ResponseEntity<Set<Finance_Account_User>>(HttpStatus.OK);
    }

    @PostMapping("/listRemove")
    public ResponseEntity<Finance_Account_User> listRemove(){
        return new ResponseEntity<Finance_Account_User>(userFinanceService.removeList(1),HttpStatus.OK);
    }

    @PostMapping("/listFromBankAccountTransaction")
    public ResponseEntity<Set<Finance_Account_User>> listFromBankAccountTransaction(){
        return new ResponseEntity<Set<Finance_Account_User>>(HttpStatus.OK);
    }

    @PostMapping("/listToBankAccountTransaction")
    public ResponseEntity<Set<Finance_Account_User>> toBankAccountTransaction(){
        return new ResponseEntity<Set<Finance_Account_User>>(HttpStatus.OK);
    }

    @PostMapping("/getStatusMoney")
    public ResponseEntity<Finance_Account_User> getStatusMoney(){
        return new ResponseEntity<Finance_Account_User>(HttpStatus.OK);
    }

}
