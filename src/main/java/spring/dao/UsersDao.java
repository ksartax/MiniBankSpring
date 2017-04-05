package spring.dao;

import spring.model.Address_User;
import spring.model.Contact_User;
import spring.model.User;

import java.util.List;

/**
 * Created by Damian Stępniak on 17.03.2017.
 */
public interface UsersDao {

    public List<User> getAll();
    public User add(User user);
    public User findByPasswordAndEmail(String password, String email) throws Exception;
    public Contact_User addContact(Contact_User contact_user);
    public Address_User addAddress(Address_User address_user);

}