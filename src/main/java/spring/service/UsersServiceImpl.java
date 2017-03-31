package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import spring.dao.UsersDao;
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
}
