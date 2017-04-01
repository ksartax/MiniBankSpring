package spring.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Damian Stępniak on 01.04.2017.
 */
@Entity
public class Address_User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int address_user_id;

    @Column(name = "CITY", nullable = true, length = 100)
    private String city;

    @Column(name = "COUNTRY", nullable = true, length = 100)
    private String country;

    @Column(name = "POST_CODE", nullable = true, length = 100)
    private String post_code;

    @Column(name = "STREET", nullable = true, length = 100)
    private String street;

    @Column(name = "HOME_NR", nullable = true, length = 100)
    private String home_nr;

    @Id
    @Column(name = "USER_ID", nullable = false)
    private int user_id;

    public int getAddress_user_id() {
        return address_user_id;
    }

    public void setAddress_user_id(int address_user_id) {
        this.address_user_id = address_user_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome_nr() {
        return home_nr;
    }

    public void setHome_nr(String home_nr) {
        this.home_nr = home_nr;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}