package spring.dao;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import spring.model.Finance_Account_User;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by Damian Stępniak on 03.04.2017.
 */

@Repository("usersFinanceDao")
@Transactional
public class UsersFinanceDaoImpl extends AbstractDao<Integer, Finance_Account_User> implements UsersFinanceDao {

    public Set<Finance_Account_User> depositList(int id) throws NoSuchElementException {
        return (Set<Finance_Account_User>) createEntityCriteria()
                .setProjection(Projections.property("deposit_into_account_id"))
                .add(Restrictions.eq("finance_account_user_id", id)).list();
    }

    public Finance_Account_User removeList(int id) throws NoSuchElementException {
        return (Finance_Account_User) createEntityCriteria()
                .list()
                .get(0);
    }

    public Set<Finance_Account_User> listFromBankAccountTransaction(int id) throws NoSuchElementException {
        return (Set<Finance_Account_User>) createEntityCriteria()
                .setProjection(Projections.property("from_bank_account_transaction_id"))
                .add(Restrictions.eq("finance_account_user_id", id)).list();
    }

    public Set<Finance_Account_User> listToBankAccountTransaction(int id) throws NoSuchElementException {
        return (Set<Finance_Account_User>) createEntityCriteria()
                .setProjection(Projections.property("to_bank_account_transaction_id"))
                .add(Restrictions.eq("finance_account_user_id", id)).list();
    }

    public Finance_Account_User getStatusMoney(int id) throws NoSuchElementException {
        return (Finance_Account_User) createEntityCriteria()
                .setProjection(Projections.property("grandtotal"))
                .setProjection(Projections.property("subtotal"))
                .add(Restrictions.eq("finance_account_user_id", id))
                .list().get(0);
    }

    public Finance_Account_User getUserFinance(int id) throws NoSuchElementException {
        return (Finance_Account_User) createEntityCriteria()
                .add(Restrictions.eq("finance_account_user_id", id))
                .list().get(0);
    }
}
