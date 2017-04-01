package spring.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.swing.text.StyleConstants.Size;

/**
 * Created by Damian Stępniak on 17.03.2017.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int user_id;

    @OneToOne
    @JoinColumn(name = "ADDRESS_USER_ID")
    private Address_User address_user_id;

    @OneToOne
    @JoinColumn(name = "CONTACT_USER_ID")
    private Contact_User contact_user_id;

    @OneToOne
    @JoinColumn(name = "FINANCE_ACCOUNT_USER_ID")
    private Finance_Account_User finance_account_user_id;

    @Column(name = "ADDRESS_IP", nullable = true, length = 100)
    private String address_ip;

    @Column(name = "FIRST_NAME", nullable = true, length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = true, length = 100)
    private String lastName;

    @Column(name = "PASSWORD", nullable = true, length = 250)
    private String password;

    @Column(name = "EMAIL", nullable = true, length = 100)
    private String email;

    @Column(name = "PROTECT_CODE", nullable = true, length = 100)
    private String protect_code;

    @Column(name = "ACTIVE", nullable = false)
    private int active;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningData;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    public Address_User getAddress_user_id() {
        return address_user_id;
    }

    public void setAddress_user_id(Address_User address_user_id) {
        this.address_user_id = address_user_id;
    }

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    public Contact_User getContact_user_id() {
        return contact_user_id;
    }


    public void setContact_user_id(Contact_User contact_user_id) {
        this.contact_user_id = contact_user_id;
    }

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    public Finance_Account_User getFinance_account_user_id() {
        return finance_account_user_id;
    }

    public void setFinance_account_user_id(Finance_Account_User finance_account_user_id) {
        this.finance_account_user_id = finance_account_user_id;
    }

    public String getAddress_ip() {
        return address_ip;
    }

    public void setAddress_ip(String address_ip) {
        this.address_ip = address_ip;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProtect_code() {
        return protect_code;
    }

    public void setProtect_code(String protect_code) {
        this.protect_code = protect_code;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public LocalDate getJoiningData() {
        return joiningData;
    }

    public void setJoiningData(LocalDate joiningData) {
        this.joiningData = joiningData;
    }
}

