package spring.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Damian Stępniak on 01.04.2017.
 */
@Entity
@Table(name = "contact_user")
public class Contact_User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int contact_user_id;

    @Column(name = "TELEPHONE", nullable = true)
    private int telephone;

    @Id
    @Column(name = "USER_ID", nullable = false)
    private User user_id;


}
