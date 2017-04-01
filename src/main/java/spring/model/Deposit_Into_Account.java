package spring.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * Created by Damian Stępniak on 01.04.2017.
 */
@Entity
public class Deposit_Into_Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int deposit_into_account_id ;

    @Column(name = "PRICE", nullable = false)
    private float price;

    @Column(name = "FINANCE_ACCOUNT_USER_ID", nullable = false)
    private int finance_account_user_id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningData;
}