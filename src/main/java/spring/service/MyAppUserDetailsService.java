package spring.service;



import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.dao.IUserInfoDAO;



/**
 * Created by Damian Stępniak on 06.04.2017.
 */
@Service
public class MyAppUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserInfoDAO userInfoDAO;
    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {



        spring.model.User activeUserInfo = userInfoDAO.getActiveUser(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority("User");

        UserDetails userDetails = (UserDetails)new User(String.valueOf(activeUserInfo.getUser_id()),
                activeUserInfo.getPassword(), Arrays.asList(authority));


        return userDetails;
    }


}
