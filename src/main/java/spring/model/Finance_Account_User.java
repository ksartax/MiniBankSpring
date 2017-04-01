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

    public int getFinance_account_user_id() {
        return finance_account_user_id;
    }

    public void setFinance_account_user_id(int finance_account_user_id) {
        this.finance_account_user_id = finance_account_user_id;
    }

    public String getBank_account_number() {
        return bank_account_number;
    }

    public void setBank_account_number(String bank_account_number) {
        this.bank_account_number = bank_account_number;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(float grandtotal) {
        this.grandtotal = grandtotal;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getProtect_code() {
        return protect_code;
    }

    public void setProtect_code(String protect_code) {
        this.protect_code = protect_code;
    }
}
