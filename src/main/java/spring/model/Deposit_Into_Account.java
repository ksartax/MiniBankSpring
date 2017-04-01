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

    @Id
    @Column(name = "FINANCE_ACCOUNT_USER_ID", nullable = false)
    private int finance_account_user_id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningData;

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