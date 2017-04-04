package spring.dao;

import spring.model.User;

import java.util.List;

/**
 * Created by Damian Stępniak on 17.03.2017.
 */
public interface UsersDao {

    public List<User> getAll();
    public User add(User user);
    public User findByPasswordAndEmail(String password, String email) throws Exception;

}