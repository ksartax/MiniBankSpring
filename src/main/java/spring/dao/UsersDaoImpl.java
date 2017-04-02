package spring.dao;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.model.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Damian Stępniak on 17.03.2017.
 */

@Repository("usersDao")
@Transactional
public class UsersDaoImpl extends AbstractDao<Integer, User> implements UsersDao{

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return (List<User>) createEntityCriteria().list();
    }

    public User add(User user) {
        getSession().persist(user);
      return user;
    }


}
