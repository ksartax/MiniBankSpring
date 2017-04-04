package spring.dao;

import spring.model.Deposit_Into_Account;
import spring.model.Remove_Into_Account;
import spring.model.To_Bank_Account_Transaction;

import java.sql.SQLException;

/**
 * Created by Damian Stępniak on 03.04.2017.
 */
public interface UserTransactionsDao {

    public void paidMoney(Deposit_Into_Account deposit_into_account) throws SQLException;
    public void transferMoney(To_Bank_Account_Transaction to_bank_account_transaction) throws SQLException;
    public void withdrawMoney(Remove_Into_Account remove_into_account) throws SQLException;

}
