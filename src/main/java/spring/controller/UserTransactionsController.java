package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.logic.RequestStatus;
import spring.model.Remove_Into_Account;
import spring.service.UserTransactionService;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */

@RestController
@RequestMapping("api/user/transaction")
public class UserTransactionsController extends AppController{

    @Autowired
    protected UserTransactionService userTransactionService;

    @PostMapping("/sendMoney")
    public ResponseEntity<RequestStatus> sendMoney(){

        return new ResponseEntity<RequestStatus>(HttpStatus.OK);
    }

    @PostMapping("/removeMoney")
    public ResponseEntity<RequestStatus> removeMoney() throws Exception {
        Remove_Into_Account remove_into_account = new Remove_Into_Account();
        remove_into_account.setPrice(100);

        //remove_into_account.setFinance_account_user_id
       //        (usersService.findByPasswordAndEmail("Seba", "Seba").getFinance_account_user_id());
       userTransactionService.withdrawMoney(remove_into_account);

        return new ResponseEntity<RequestStatus>(new RequestStatus(null,null,remove_into_account),HttpStatus.OK);
    }

    @PostMapping("/depositMoney")
    public ResponseEntity<RequestStatus> depositMoney(){

        return new ResponseEntity<RequestStatus>(HttpStatus.OK);
    }

}