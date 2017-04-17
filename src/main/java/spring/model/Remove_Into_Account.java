package spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "remove_into_account")
public class Remove_Into_Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "remove_into_account_id", unique = true)
    private int remove_into_account_id ;

    @Column(name = "PRICE", nullable = false)
    private float price;

    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "finance_account_user")
    @JsonIgnore
    private Finance_Account_User finance_account_user;

    public Finance_Account_User getFinance_account_user() {
        return finance_account_user;
    }

    public void setFinance_account_user(Finance_Account_User finance_account_user) {
        this.finance_account_user = finance_account_user;
    }

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}