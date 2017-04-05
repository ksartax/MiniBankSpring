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

   protected static HttpHeaders getHeaders(String username, String email){
        String plainCredentials=username+":"+email;
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    @PostMapping("/register")
    public ResponseEntity<RequestStatus> register(@RequestBody JsonNode string){

        try {
            User user;
            user = new ConvertValue<User>(User.class, string).convertToObject("user");

            user.setAddress_user_id(usersService.
                    addAddress(new ConvertValue<Address_User>(Address_User.class, string)
                            .convertToObject("address")));

            user.setContact_user_id(usersService.
                    addContact(new ConvertValue<Contact_User>(Contact_User.class, string)
                            .convertToObject("contact")));

            usersService.add(user);
            return new ResponseEntity<RequestStatus>(new RequestStatus("success", ""), HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<RequestStatus>(new RequestStatus("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (PropertyValueException e){
            return new ResponseEntity<RequestStatus>(new RequestStatus("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<RequestStatus>  login(@RequestBody JsonNode string){
        try {
            ConvertValue<UserLogin> convertValue = new ConvertValue<UserLogin>(UserLogin.class,string);
            UserLogin userLogin = convertValue.convertToObject("login");
            User user = usersService.findByPasswordAndEmail(userLogin.getPassword(), userLogin.getEmail());

            return new ResponseEntity<RequestStatus>(new RequestStatus("success", "", user, getHeaders(user.getPassword(), user.getEmail()).toString()), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<RequestStatus>(new RequestStatus("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<RequestStatus>(new RequestStatus("notAuthorization", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
