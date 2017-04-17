package spring.dao;

/**
 * Created by Damian Stępniak on 11.04.2017.
 */
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.model.User;

import static org.springframework.http.HttpHeaders.FROM;


/**
 * Created by Damian Stępniak on 07.04.2017.
 */
@Repository
@Transactional
@ComponentScan(value = "spring.configuration")
public class UserInfoDao implements IUserInfoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getActiveUser(String userName) {
        User activeUserInfo = new User();

        System.out.print(userName);

        List list = sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("password", userName))
               // .add(Restrictions.eq("email",email))
                .list();

        if(!list.isEmpty()) {
            activeUserInfo = (User)list.get(0);
        }

        return activeUserInfo;
    }
}
