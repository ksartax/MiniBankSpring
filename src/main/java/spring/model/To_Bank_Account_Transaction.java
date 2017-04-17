package spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @OneToOne
    @JoinColumn(name = "to_finance_account_user_id")
    private Finance_Account_User to_finance_account_user_id;

    @Column(name = "PRICE", nullable = false)
    private float price;

    @ManyToOne
    @JoinColumn(name = "finance_account_user_id")
    @JsonIgnore
    private Finance_Account_User finance_account_user_id;

    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Ignore
    private String pom;

    public String getPom() {
        return pom;
    }

    public void setPom(String pom) {
        this.pom = pom;
    }

    public int getTo_bank_account_transaction_id() {
        return to_bank_account_transaction_id;
    }

    public void setTo_bank_account_transaction_id(int to_bank_account_transaction_id) {
        this.to_bank_account_transaction_id = to_bank_account_transaction_id;
    }

    public Finance_Account_User getTo_finance_account_user_id() {
        return to_finance_account_user_id;
    }

    public void setTo_finance_account_user_id(Finance_Account_User to_finance_account_user_id) {
        this.to_finance_account_user_id = to_finance_account_user_id;
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