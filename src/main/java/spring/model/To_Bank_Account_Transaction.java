package spring.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Damian Stępniak on 01.04.2017.
 */
@Entity
@Table(name = "to_bank_account_transaction")
public class To_Bank_Account_Transaction implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int to_bank_account_transaction_id;

    @Column(name = "FROM_FINANCE_ACCOUNT_USER_ID", nullable = false)
    private Finance_Account_User from_finance_account_user_id;

    @Column(name = "PRICE", nullable = false)
    private float price;

    @Id
    @Column(name = "FINANCE_ACCOUNT_USER_ID", nullable = false)
    private Finance_Account_User finance_account_user_id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningData;


}