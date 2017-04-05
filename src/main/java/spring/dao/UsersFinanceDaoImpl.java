package spring.dao;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import spring.model.Finance_Account_User;
import spring.model.Remove_Into_Account;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by Damian Stępniak on 03.04.2017.
 */

@Repository("usersFinanceDao")
@Transactional
public class UsersFinanceDaoImpl extends AbstractDao<Integer, Finance_Account_User> implements UsersFinanceDao {

    public Finance_Account_User depositList(int id) throws NoSuchElementException {
        Finance_Account_User finance_account_user = (Finance_Account_User) createEntityCriteria()
                .add(Restrictions.eq("finance_account_user_id", id))
                .list()
                .get(0);

        finance_account_user
                .setRemove_into_account
                        ((List<Remove_Into_Account>) getSession()
                                .createQuery("from Remove_Into_Account where finance_account_user = " + finance_account_user.getFinance_account_user_id()).list());

        return finance_account_user;
    }

    public Finance_Account_User removeList(int id) throws NoSuchElementException {

        Finance_Account_User finance_account_user = (Finance_Account_User) createEntityCriteria()
                .add(Restrictions.eq("finance_account_user_id", id))
                .list()
                .get(0);

        finance_account_user
                .setRemove_into_account
                        ((List<Remove_Into_Account>) getSession()
                                .createQuery("from Remove_Into_Account where finance_account_user = " + finance_account_user.getFinance_account_user_id()).list());

        return finance_account_user;
    }

    public Finance_Account_User listFromBankAccountTransaction(int id) throws NoSuchElementException {

        Finance_Account_User finance_account_user = (Finance_Account_User) createEntityCriteria()
                .add(Restrictions.eq("finance_account_user_id", id))
                .list()
                .get(0);

        finance_account_user
                .setRemove_into_account
                        ((List<Remove_Into_Account>) getSession()
                                .createQuery("from Remove_Into_Account where finance_account_user = " + finance_account_user.getFinance_account_user_id()).list());

        return finance_account_user;
    }

    public Finance_Account_User listToBankAccountTransaction(int id) throws NoSuchElementException {

        Finance_Account_User finance_account_user = (Finance_Account_User) createEntityCriteria()
                .add(Restrictions.eq("finance_account_user_id", id))
                .list()
                .get(0);

        finance_account_user
                .setRemove_into_account
                        ((List<Remove_Into_Account>) getSession()
                                .createQuery("from Remove_Into_Account where finance_account_user = " + finance_account_user.getFinance_account_user_id()).list());

        return finance_account_user;
    }

    public Finance_Account_User getStatusMoney(int id) throws NoSuchElementException {

        Finance_Account_User finance_account_user = (Finance_Account_User) createEntityCriteria()
                .add(Restrictions.eq("finance_account_user_id", id))
                .list()
                .get(0);

        finance_account_user
                .setRemove_into_account
                        ((List<Remove_Into_Account>) getSession()
                                .createQuery("from Remove_Into_Account where finance_account_user = " + finance_account_user.getFinance_account_user_id()).list());

        return finance_account_user;
    }

    public Finance_Account_User getUserFinance(int id) throws NoSuchElementException {

        Finance_Account_User finance_account_user = (Finance_Account_User) createEntityCriteria()
                .add(Restrictions.eq("finance_account_user_id", id))
                .list()
                .get(0);

        finance_account_user
                .setRemove_into_account
                        ((List<Remove_Into_Account>) getSession()
                                .createQuery("from Remove_Into_Account where finance_account_user = " + finance_account_user.getFinance_account_user_id()).list());

        return finance_account_user;
    }
}
