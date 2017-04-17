package spring.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.logic.ConvertValue;
import spring.logic.RequestStatus;
import spring.model.Deposit_Into_Account;
import spring.model.Remove_Into_Account;
import spring.model.To_Bank_Account_Transaction;
import spring.service.UserFinanceService;
import spring.service.UserTransactionService;

/**
 * Created by Damian Stępniak on 02.04.2017.
 */

@RestController
@RequestMapping("api/user/transaction")
public class UserTransactionsController extends AppController{

    @Autowired
    protected UserTransactionService userTransactionService;

    @Autowired
    private UserFinanceService userFinanceService;

    @PostMapping("/sendMoney")
    public ResponseEntity<RequestStatus> sendMoney(@RequestBody JsonNode string) throws Exception {

        To_Bank_Account_Transaction to_bank_account = new ConvertValue<To_Bank_Account_Transaction>(To_Bank_Account_Transaction.class, string).convertToObject();

        To_Bank_Account_Transaction to_bank_account_T = new To_Bank_Account_Transaction();

        to_bank_account_T.setTo_finance_account_user_id(userFinanceService.getBasicFinanceAccountUserNyAccountNumber(to_bank_account.getPom()));

        to_bank_account_T.setFinance_account_user_id
                (usersService.findById
                        (
                                Integer.valueOf(SecurityContextHolder.getContext().getAuthentication().getName())
                        )
                    .getFinance_account_user_id());

        to_bank_account_T.setPrice(to_bank_account.getPrice());

        to_bank_account_T.setCreateDate(to_bank_account.getCreateDate());

        userTransactionService.transferMoney(to_bank_account_T);

        return new ResponseEntity<RequestStatus>(new RequestStatus("Success",null),HttpStatus.OK);
    }

    @PostMapping("/removeMoney")
    public ResponseEntity<RequestStatus> removeMoney(@RequestBody JsonNode string) throws Exception {

        Remove_Into_Account remove_into_account = new ConvertValue<Remove_Into_Account>(Remove_Into_Account.class, string).convertToObject();

        remove_into_account.setFinance_account_user
               (usersService.findById
                       (
                               Integer.valueOf(SecurityContextHolder.getContext().getAuthentication().getName())
                       )
                       .getFinance_account_user_id());
       userTransactionService.withdrawMoney(remove_into_account);

        return new ResponseEntity<RequestStatus>(new RequestStatus(null,null,remove_into_account),HttpStatus.OK);
    }

    @PostMapping("/depositMoney")
    public ResponseEntity<RequestStatus> depositMoney(@RequestBody JsonNode string) throws Exception {

        Deposit_Into_Account deposit_into_account;
        deposit_into_account = new ConvertValue<Deposit_Into_Account>(Deposit_Into_Account.class, string).convertToObject();

        deposit_into_account.setFinance_account_user_id
                (usersService.findById
                        (
                                Integer.valueOf(SecurityContextHolder.getContext().getAuthentication().getName())
                        )
                        .getFinance_account_user_id());

        userTransactionService.paidMoney(deposit_into_account);

        return new ResponseEntity<RequestStatus>(new RequestStatus("success", null, deposit_into_account) ,HttpStatus.OK);
    }

}