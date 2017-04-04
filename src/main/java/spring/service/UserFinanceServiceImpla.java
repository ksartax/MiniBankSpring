package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import spring.dao.UsersFinanceDao;
import spring.model.Finance_Account_User;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by Damian Stępniak on 03.04.2017.
 */
@Service("userFinanceService")
@ComponentScan(value = "spring.dao")
@Transactional
public class UserFinanceServiceImpla implements UserFinanceService{

    @Autowired
    private UsersFinanceDao usersFinanceDao;

    public Set<Finance_Account_User> depositList(int id) throws NoSuchElementException {
        return usersFinanceDao.depositList(id);
    }

    public Finance_Account_User removeList(int id) throws NoSuchElementException {
        return usersFinanceDao.removeList(id);
    }

    public Set<Finance_Account_User> listFromBankAccountTransaction(int id) throws NoSuchElementException {
        return usersFinanceDao.listFromBankAccountTransaction(id);
    }

    public Set<Finance_Account_User> listToBankAccountTransaction(int id) throws NoSuchElementException {
        return usersFinanceDao.listToBankAccountTransaction(id);
    }

    public Finance_Account_User getStatusMoney(int id) throws NoSuchElementException {
        return usersFinanceDao.getStatusMoney(id);
    }

    public Finance_Account_User getUserFinance(int id) throws NoSuchElementException {
        return usersFinanceDao.getUserFinance(id);
    }
}
