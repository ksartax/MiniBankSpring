package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import spring.dao.UserTransactionsDao;
import spring.model.Deposit_Into_Account;
import spring.model.Remove_Into_Account;
import spring.model.To_Bank_Account_Transaction;

import javax.transaction.Transactional;
import java.sql.SQLException;

/**
 * Created by Damian Stępniak on 03.04.2017.
 */

@Service("usersTransactionService")
@ComponentScan(value = "spring.dao")
@Transactional
public class UserTransactionServiceImpl implements UserTransactionService{

    @Autowired
    private UserTransactionsDao userTransactionsDao;


    public void paidMoney(Deposit_Into_Account deposit_into_account) throws SQLException {
        userTransactionsDao.paidMoney(deposit_into_account);
    }

    public void transferMoney(To_Bank_Account_Transaction to_bank_account_transaction) throws SQLException {
        userTransactionsDao.transferMoney(to_bank_account_transaction);
    }

    public void withdrawMoney(Remove_Into_Account remove_into_account) throws SQLException {
        userTransactionsDao.withdrawMoney(remove_into_account);
    }
}
