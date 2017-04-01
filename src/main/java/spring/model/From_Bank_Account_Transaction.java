package spring.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Damian Stępniak on 01.04.2017.
 */

@Entity
public class From_Bank_Account_Transaction implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int from_bank_account_transaction_id;

    @Column(name = "TO_FINANCE_ACCOUNT_USER_ID", nullable = false)
    private int to_finance_account_user_id;

    @Column(name = "PRICE", nullable = false)
    private float price;

    @Column(name = "FINANCE_ACCOUNT_USER_ID", nullable = false)
    private int finance_account_user_id;

}
