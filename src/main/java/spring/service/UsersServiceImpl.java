package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.dao.UsersDao;
import spring.model.Address_User;
import spring.model.Contact_User;
import spring.model.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Damian Stępniak on 17.03.2017.
 */
@Service("usersService")
@ComponentScan(value = "spring.dao")
@Transactional
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersDao usersDao;

    public List<User> getAll() {
        return usersDao.getAll();
    }

    public User add(User user) {
        return usersDao.add(user);
    }

    public User findByPasswordAndEmail(String password, String email) throws Exception {
        return usersDao.findByPasswordAndEmail(password, email);
    }

    public Contact_User addContact(Contact_User contact_user) {
       return usersDao.addContact(contact_user);
    }

    public Address_User addAddress(Address_User address_user) {
       return usersDao.addAddress(address_user);
    }
}
