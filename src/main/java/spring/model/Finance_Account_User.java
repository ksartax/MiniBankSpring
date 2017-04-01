package spring.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Damian Stępniak on 01.04.2017.
 */
@Entity
@Table(name = "finance_account_user")
public class Finance_Account_User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int finance_account_user_id;

    @Column(name = "BANK_ACCOUNT_NUMBER", nullable = false, length = 100)
    private String bank_account_number;

    @Column(name = "SUBTOTAL", nullable = false)
    private float subtotal;

    @Column(name = "GRANDTOTAL", nullable = false)
    private float grandtotal;

    @Id
    @Column(name = "USER_ID", nullable = false)
    private User user_id;

    @Column(name = "PROTECT_CODE", nullable = true, length = 100)
    private String protect_code;

}
