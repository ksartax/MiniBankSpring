package spring.dao;


import spring.model.User;

public interface IUserInfoDAO {
    User getActiveUser(String userName);
}
