package spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Damian Stępniak on 01.04.2017.
 */
@Entity
@Table(name = "finance_account_user")
public class Finance_Account_User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finance_account_user_id",unique = true)
    private int finance_account_user_id;

    @OneToMany
    private Set<Deposit_Into_Account> deposit_into_account_id ;

    @OneToMany
    private Set<From_Bank_Account_Transaction> from_bank_account_transaction_id;

    @OneToMany
    private Set<Remove_Into_Account> remove_into_account = new HashSet<Remove_Into_Account>();

    @OneToMany
    private Set<To_Bank_Account_Transaction> to_bank_account_transaction_id;

    @Column(name = "BANK_ACCOUNT_NUMBER", nullable = false, length = 100)
    private String bank_account_number;

    @Column(name = "SUBTOTAL", nullable = false)
    private float subtotal;

    @Column(name = "GRANDTOTAL", nullable = false)
    private float grandtotal;

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

    public String getProtect_code() {
        return protect_code;
    }

    public void setProtect_code(String protect_code)
    {
        this.protect_code = protect_code;
    }

    public Set<Deposit_Into_Account> getDeposit_into_account_id() {
        return deposit_into_account_id;
    }

    public void setDeposit_into_account_id(Set<Deposit_Into_Account> deposit_into_account_id) {
        this.deposit_into_account_id = deposit_into_account_id;
    }

    public Set<From_Bank_Account_Transaction> getFrom_bank_account_transaction_id() {
        return from_bank_account_transaction_id;
    }

    public void setFrom_bank_account_transaction_id(Set<From_Bank_Account_Transaction> from_bank_account_transaction_id) {
        this.from_bank_account_transaction_id = from_bank_account_transaction_id;
    }


    public Set<To_Bank_Account_Transaction> getTo_bank_account_transaction_id() {
        return to_bank_account_transaction_id;
    }

    public void setTo_bank_account_transaction_id(Set<To_Bank_Account_Transaction> to_bank_account_transaction_id) {
        this.to_bank_account_transaction_id = to_bank_account_transaction_id;
   }

    public void addMoney(float money){
        this.subtotal += money;
    }

    public void subMoney(float money){
        this.subtotal -= money;
    }

    public Set<Remove_Into_Account> getRemove_into_account() {
        return remove_into_account;
    }

    public void setRemove_into_account(Set<Remove_Into_Account> remove_into_account) {
        this.remove_into_account = remove_into_account;
    }

    @Override
    public String toString() {
        return "Finance_Account_User{" +
                "finance_account_user_id=" + finance_account_user_id +
                ", deposit_into_account_id=" + deposit_into_account_id +
                ", from_bank_account_transaction_id=" + from_bank_account_transaction_id +
                ", remove_into_account_id=" + remove_into_account +
                ", to_bank_account_transaction_id=" + to_bank_account_transaction_id +
                ", bank_account_number='" + bank_account_number + '\'' +
                ", subtotal=" + subtotal +
                ", grandtotal=" + grandtotal +
                ", protect_code='" + protect_code + '\'' +
                '}';
    }
}
