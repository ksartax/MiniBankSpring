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
 * Created by Damian Stępniak on 12.04.2017.
 */

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    protected UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<RequestStatus>  login(){

        return new ResponseEntity<RequestStatus>(new RequestStatus("success", ""), HttpStatus.OK);

    }

}
