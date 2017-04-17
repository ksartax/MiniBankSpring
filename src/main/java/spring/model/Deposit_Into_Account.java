package spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Damian Stępniak on 01.04.2017.
 */
@Entity
@Table(name = "deposit_into_account")
public class Deposit_Into_Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int deposit_into_account_id ;

    @Column(name = "PRICE", nullable = false)
    private float price;

    @ManyToOne
    @JoinColumn(name = "finance_account_user_id")
    @JsonIgnore
    private Finance_Account_User finance_account_user_id;



    public int getDeposit_into_account_id() {
        return deposit_into_account_id;
    }

    public void setDeposit_into_account_id(int deposit_into_account_id) {
        this.deposit_into_account_id = deposit_into_account_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Finance_Account_User getFinance_account_user_id() {
        return finance_account_user_id;
    }

    public void setFinance_account_user_id(Finance_Account_User finance_account_user_id) {
        this.finance_account_user_id = finance_account_user_id;
    }


}