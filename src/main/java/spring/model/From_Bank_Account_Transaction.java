package spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Damian Stępniak on 01.04.2017.
 */

@Entity
@Table(name = "from_bank_account_transaction")
public class From_Bank_Account_Transaction implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int from_bank_account_transaction_id;

    @OneToOne
    @JoinColumn(name = "TO_FINANCE_ACCOUNT_USER_ID")
    private Finance_Account_User to_finance_account_user_id;

    @Column(name = "PRICE", nullable = false)
    private float price;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "finance_account_user_id")
    private Finance_Account_User finance_account_user_id ;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "create_data", nullable = false)
    private LocalDate joiningData;

    public int getFrom_bank_account_transaction_id() {
        return from_bank_account_transaction_id;
    }

    public void setFrom_bank_account_transaction_id(int from_bank_account_transaction_id) {
        this.from_bank_account_transaction_id = from_bank_account_transaction_id;
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

    public LocalDate getJoiningData() {
        return joiningData;
    }

    public void setJoiningData(LocalDate joiningData) {
        this.joiningData = joiningData;
    }
}
