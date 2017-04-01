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
public class To_Bank_Account_Transaction implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int to_bank_account_transaction_id;

    @Column(name = "FROM_FINANCE_ACCOUNT_USER_ID", nullable = false)
    private int from_finance_account_user_id;

    @Column(name = "PRICE", nullable = false)
    private float price;

    @Id
    @Column(name = "FINANCE_ACCOUNT_USER_ID", nullable = false)
    private int finance_account_user_id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningData;

    public int getTo_bank_account_transaction_id() {
        return to_bank_account_transaction_id;
    }

    public void setTo_bank_account_transaction_id(int to_bank_account_transaction_id) {
        this.to_bank_account_transaction_id = to_bank_account_transaction_id;
    }

    public int getFrom_finance_account_user_id() {
        return from_finance_account_user_id;
    }

    public void setFrom_finance_account_user_id(int from_finance_account_user_id) {
        this.from_finance_account_user_id = from_finance_account_user_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getFinance_account_user_id() {
        return finance_account_user_id;
    }

    public void setFinance_account_user_id(int finance_account_user_id) {
        this.finance_account_user_id = finance_account_user_id;
    }

    public LocalDate getJoiningData() {
        return joiningData;
    }

    public void setJoiningData(LocalDate joiningData) {
        this.joiningData = joiningData;
    }
}