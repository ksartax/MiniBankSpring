package spring.dao;

import spring.model.Finance_Account_User;

import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by Damian Stępniak on 03.04.2017.
 */


public interface UsersFinanceDao {

    public Finance_Account_User depositList(int id) throws NoSuchElementException;
    public Finance_Account_User removeList(int id) throws NoSuchElementException;
    public Finance_Account_User listFromBankAccountTransaction(int id) throws NoSuchElementException;
    public Finance_Account_User listToBankAccountTransaction(int id) throws NoSuchElementException;
    public Finance_Account_User getStatusMoney(int id) throws NoSuchElementException;
    public Finance_Account_User getUserFinance(int id) throws NoSuchElementException;
    public Finance_Account_User getBasicFinanceAccountUserNyAccountNumber(String account_number);

}
