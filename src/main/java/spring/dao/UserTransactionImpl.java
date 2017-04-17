package spring.dao;

import org.springframework.stereotype.Repository;
import spring.model.Deposit_Into_Account;
import spring.model.Finance_Account_User;
import spring.model.Remove_Into_Account;
import spring.model.To_Bank_Account_Transaction;

import javax.transaction.Transactional;
import java.sql.SQLException;

/**
 * Created by Damian Stępniak on 03.04.2017.
 */

@Repository("usersTransactionDao")
@Transactional
public class UserTransactionImpl extends AbstractDao<Integer, Finance_Account_User> implements UserTransactionsDao{

    public void paidMoney(Deposit_Into_Account deposit_into_account) throws SQLException {
        deposit_into_account.getFinance_account_user_id().addMoney(deposit_into_account.getPrice());
        getSession().update(deposit_into_account.getFinance_account_user_id());
        getSession().persist(deposit_into_account);
    }

    public void transferMoney(To_Bank_Account_Transaction to_bank_account_transaction) throws SQLException {
        to_bank_account_transaction.getTo_finance_account_user_id().addMoney(to_bank_account_transaction.getPrice());
        to_bank_account_transaction.getFinance_account_user_id().subMoney(to_bank_account_transaction.getPrice());
        getSession().update(to_bank_account_transaction.getFinance_account_user_id());
        getSession().update(to_bank_account_transaction.getTo_finance_account_user_id());
        getSession().persist(to_bank_account_transaction);
    }

    public void withdrawMoney(Remove_Into_Account remove_into_account) throws SQLException {
        remove_into_account.getFinance_account_user().subMoney(remove_into_account.getPrice());
        getSession().update(remove_into_account.getFinance_account_user());
        getSession().persist(remove_into_account);
    }
}
