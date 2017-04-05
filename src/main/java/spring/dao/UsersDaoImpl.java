package spring.dao;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import spring.logic.FinanceAccountUserPinGeneration;
import spring.model.Address_User;
import spring.model.Contact_User;
import spring.model.Finance_Account_User;
import spring.model.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Damian Stępniak on 17.03.2017.
 */

@Repository("usersDao")
@Transactional
public class UsersDaoImpl extends AbstractDao<Integer, User> implements UsersDao{

    public List<User> getAll() {
        return (List<User>) createEntityCriteria().list();
    }

    public User add(User user) {
        FinanceAccountUserPinGeneration financeAccountUserPinGeneration = new FinanceAccountUserPinGeneration();
        Finance_Account_User finance_account_user = new Finance_Account_User();
        finance_account_user.setBank_account_number(financeAccountUserPinGeneration.nextSessionId());
        getSession().persist(finance_account_user);
        user.setFinance_account_user_id(finance_account_user);
        getSession().persist(user);
      return user;
    }

    public User findByPasswordAndEmail(String password, String email) throws Exception {
        List list = createEntityCriteria()
                .add(Restrictions.eq("password", password))
                .add(Restrictions.eq("email",email))
                .list();

        if(list.size() == 0){
            throw new Exception();
        }
        return (User) list.get(0);
    }

    public Contact_User addContact(Contact_User contact_user) {
        getSession().save(contact_user);
        return contact_user;
    }

    public Address_User addAddress(Address_User address_user) {
        getSession().save(address_user);
        return address_user;
    }


}
