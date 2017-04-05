package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.logic.RequestStatus;
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
    public ResponseEntity<RequestStatus> getUserFinance(){

        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success", "", userFinanceService.getUserFinance(1)),HttpStatus.OK);
    }

    @PostMapping("/listDeposit")
    public ResponseEntity<RequestStatus> listDeposit(){
        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success", "", userFinanceService.depositList(1)) ,HttpStatus.OK);
    }

    @PostMapping("/listRemove")
    public ResponseEntity<RequestStatus> listRemove(){
        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success","",userFinanceService.removeList(1)) ,HttpStatus.OK);
    }

    @PostMapping("/listFromBankAccountTransaction")
    public ResponseEntity<RequestStatus> listFromBankAccountTransaction(){
        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success","", userFinanceService.listFromBankAccountTransaction(1)) ,HttpStatus.OK);
    }

    @PostMapping("/listToBankAccountTransaction")
    public ResponseEntity<RequestStatus> toBankAccountTransaction(){
        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success", "", userFinanceService.listToBankAccountTransaction(1)) ,HttpStatus.OK);
    }

    @PostMapping("/getStatusMoney")
    public ResponseEntity<RequestStatus> getStatusMoney(){
        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success", "", userFinanceService.getStatusMoney(1)) ,HttpStatus.OK);
    }

}
