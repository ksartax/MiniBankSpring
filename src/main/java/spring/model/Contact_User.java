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

    public int getContact_user_id() {
        return contact_user_id;
    }

    public void setContact_user_id(int contact_user_id) {
        this.contact_user_id = contact_user_id;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

}
