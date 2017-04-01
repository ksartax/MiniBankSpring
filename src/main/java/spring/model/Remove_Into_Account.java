package spring.model;

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
@Table(name = "remove_into_account")
public class Remove_Into_Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int remove_into_account_id ;

    @Column(name = "PRICE", nullable = false)
    private float price;

    private Set<Finance_Account_User> finance_account_user_id = new HashSet<Finance_Account_User>();

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningData;

    public int getRemove_into_account_id() {
        return remove_into_account_id;
    }

    public void setRemove_into_account_id(int remove_into_account_id) {
        this.remove_into_account_id = remove_into_account_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Finance_Account_User> getFinance_account_user_id() {
        return finance_account_user_id;
    }

    public void setFinance_account_user_id(Set<Finance_Account_User> finance_account_user_id) {
        this.finance_account_user_id = finance_account_user_id;
    }

    public LocalDate getJoiningData() {
        return joiningData;
    }

    public void setJoiningData(LocalDate joiningData) {
        this.joiningData = joiningData;
    }
}