package spring.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import spring.logic.ConvertValue;
import spring.logic.RequestStatus;
import spring.logic.UserLogin;
import spring.model.Address_User;
import spring.model.Contact_User;
import spring.model.User;
import spring.service.MyAppUserDetailsService;
import spring.service.UsersService;

import java.io.IOException;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
/**
 * Created by Damian Stępniak on 17.03.2017.
 */

@RestController
@RequestMapping("api")
public class AppController {

    @Autowired
    protected UsersService usersService;


    @PostMapping("/register")
    public ResponseEntity<RequestStatus> register(@RequestBody JsonNode string){

        try {
            User user;
            user = new ConvertValue<User>(User.class, string).convertToObject();

            usersService.add(user);
            return new ResponseEntity<RequestStatus>(new RequestStatus("success", ""), HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<RequestStatus>(new RequestStatus("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (PropertyValueException e){
            return new ResponseEntity<RequestStatus>(new RequestStatus("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

}
