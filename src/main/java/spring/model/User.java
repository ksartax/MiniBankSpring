package spring.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.swing.text.StyleConstants.Size;

/**
 * Created by Damian Stępniak on 17.03.2017.
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int id_user;

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String lastName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningData;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getJoiningData() {
        return joiningData;
    }

    public void setJoiningData(LocalDate joiningData) {
        this.joiningData = joiningData;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", joiningData=" + joiningData +
                '}';
    }


}

