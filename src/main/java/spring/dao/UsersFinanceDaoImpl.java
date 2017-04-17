package spring.dao;

import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.SQLGrammarException;
import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.springframework.stereotype.Repository;
import spring.model.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Damian Stępniak on 03.04.2017.
 */

@SuppressWarnings("unchecked")
@Repository("usersFinanceDao")
@Transactional
public class UsersFinanceDaoImpl extends AbstractDao<Integer, Finance_Account_User> implements UsersFinanceDao {

    public Finance_Account_User getBasicFinanceAccountUser(int id) {
        return (Finance_Account_User) createEntityCriteria()
                .add(Restrictions.eq("finance_account_user_id", id))
                .list()
                .get(0);
    }

    public Finance_Account_User getBasicFinanceAccountUserNyAccountNumber(String id) {
        return (Finance_Account_User) createEntityCriteria()
                .add(Restrictions.eq("bank_account_number", id))
                .list()
                .get(0);
    }

    public Finance_Account_User depositList(int id) throws NoSuchElementException {

        Finance_Account_User finance_account_user = getBasicFinanceAccountUser(id);

        finance_account_user
                .setDeposit_into_account(
                        (List<Deposit_Into_Account>) getSession()
                                .createQuery
                                        ("from Deposit_Into_Account where finance_account_user_id = "
                                                + id)
                                .list());

        return finance_account_user;
    }

    public Finance_Account_User removeList(int id) throws NoSuchElementException {

        Finance_Account_User finance_account_user = getBasicFinanceAccountUser(id);

        finance_account_user
                .setRemove_into_account
                        ((List<Remove_Into_Account>) getSession()
                                .createQuery
                                        ("from Remove_Into_Account where finance_account_user = "
                                                + id)
                                .list());

        return finance_account_user;
    }

    public Finance_Account_User listFromBankAccountTransaction(int id) throws NoSuchElementException {

        Finance_Account_User finance_account_user = getBasicFinanceAccountUser(id);

        finance_account_user
                .setFrom_bank_account_transaction
                        ((List<From_Bank_Account_Transaction>) getSession()
                                .createQuery
                                        ("from From_Bank_Account_Transaction where finance_account_user_id = "
                                                + id)
                                .list());

        return finance_account_user;
    }

    public Finance_Account_User listToBankAccountTransaction(int id) throws NoSuchElementException {

        Finance_Account_User finance_account_user = getBasicFinanceAccountUser(id);

        finance_account_user
                .setTo_bank_account_transaction(
                        (List<To_Bank_Account_Transaction>) getSession()
                                .createQuery
                                        ("from To_Bank_Account_Transaction where finance_account_user_id = "
                                                + finance_account_user.getFinance_account_user_id())
                                .list());

        return finance_account_user;
    }

    public Finance_Account_User getStatusMoney(int id) throws NoSuchElementException {

        Finance_Account_User finance_account_user = (Finance_Account_User) createEntityCriteria()
                .add(Restrictions.eq("finance_account_user_id", id))
                .list().get(0);
        return finance_account_user;
    }

    public Finance_Account_User getUserFinance(int id) throws NoSuchElementException {

        Finance_Account_User finance_account_user = getBasicFinanceAccountUser(id);

        try {
            finance_account_user.setTo_bank_account_transaction(this.listToBankAccountTransaction(id).getTo_bank_account_transaction());
        } catch (SQLGrammarException $e) {

        } catch (QuerySyntaxException $e) {

        }

        try {
            finance_account_user.setFrom_bank_account_transaction(this.listFromBankAccountTransaction(id).getFrom_bank_account_transaction());
        } catch (SQLGrammarException $e) {

        } catch (QuerySyntaxException $e) {

        }

        try {
            finance_account_user.setDeposit_into_account(this.depositList(id).getDeposit_into_account());
        } catch (SQLGrammarException $e) {

        } catch (QuerySyntaxException $e) {

        }

        try {
            finance_account_user.setRemove_into_account(this.removeList(id).getRemove_into_account());
        } catch (SQLGrammarException $e) {

        } catch (QuerySyntaxException $e) {

        }

        return finance_account_user;
    }
}
