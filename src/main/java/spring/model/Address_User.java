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

    @Column(name = "COUNTRY_ID", nullable = true)
    private int country_id;

    @Column(name = "POST_CODE", nullable = true, length = 100)
    private String post_code;

    @Column(name = "STREET", nullable = true, length = 100)
    private String street;

    @Column(name = "HOME_NR", nullable = true, length = 100)
    private String home_nr;

    @Column(name = "USER_ID", nullable = false)
    private int user_id;
}