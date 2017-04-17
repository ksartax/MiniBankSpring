package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.logic.RequestStatus;
import spring.model.Finance_Account_User;
import spring.model.User;
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

        User user = usersService.findById
                (
                        Integer.valueOf(SecurityContextHolder.getContext().getAuthentication().getName())
                );

        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success", "", userFinanceService.getUserFinance(user.getFinance_account_user_id().getFinance_account_user_id())),HttpStatus.OK);
    }

    @PostMapping("/listDeposit")
    public ResponseEntity<RequestStatus> listDeposit(){

        User user = usersService.findById
                (
                        Integer.valueOf(SecurityContextHolder.getContext().getAuthentication().getName())
                );

        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success", "", userFinanceService.depositList(user.getFinance_account_user_id().getFinance_account_user_id())) ,HttpStatus.OK);
    }

    @PostMapping("/listRemove")
    public ResponseEntity<RequestStatus> listRemove(){

        User user = usersService.findById
                (
                        Integer.valueOf(SecurityContextHolder.getContext().getAuthentication().getName())
                );

        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success","",userFinanceService.removeList(user.getFinance_account_user_id().getFinance_account_user_id())) ,HttpStatus.OK);
    }

    @PostMapping("/listFromBankAccountTransaction")
    public ResponseEntity<RequestStatus> listFromBankAccountTransaction(){

       User user = usersService.findById
                (
                        Integer.valueOf(SecurityContextHolder.getContext().getAuthentication().getName())
                );

        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success","", userFinanceService.listFromBankAccountTransaction(user.getFinance_account_user_id().getFinance_account_user_id())) ,HttpStatus.OK);
    }

    @PostMapping("/listToBankAccountTransaction")
    public ResponseEntity<RequestStatus> toBankAccountTransaction(){

        User user = usersService.findById
                (
                        Integer.valueOf(SecurityContextHolder.getContext().getAuthentication().getName())
                );

        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success", "", userFinanceService.listToBankAccountTransaction(user.getFinance_account_user_id().getFinance_account_user_id())) ,HttpStatus.OK);
    }

    @PostMapping("/getStatusMoney")
    public ResponseEntity<RequestStatus> getStatusMoney(){



        return new ResponseEntity<RequestStatus>(
                new RequestStatus
                        ("success", "", userFinanceService.getStatusMoney(1)) ,HttpStatus.OK);
    }

}
