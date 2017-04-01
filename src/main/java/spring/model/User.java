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
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int user_id;

    @Column(name = "FIRST_NAME", nullable = true, length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = true, length = 100)
    private String lastName;

    @Column(name = "PASSWORD", nullable = true, length = 250)
    private String password;

    @Column(name = "EMAIL", nullable = true, length = 100)
    private String email;

    @Column(name = "ADDRESS_USER_ID", nullable = true)
    private int address_user_id;

    @Column(name = "CONTACT_USER_ID", nullable = true)
    private int contact_user_id;

    @Column(name = "FINANCE_ACCOUNT_USER_ID", nullable = true)
    private int finance_account_user_id;

    @Column(name = "PROTECT_CODE", nullable = true, length = 100)
    private String protect_code;

    @Column(name = "ADDRESS_IP", nullable = true, length = 100)
    private String address_ip;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningData;

}

