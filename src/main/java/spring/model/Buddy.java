package spring.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Damian Stępniak on 01.04.2017.
 */
@Entity
@Table(name = "buddy")
public class Buddy implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int buddy_id;

    @Column(name = "ENEMY_USER_ID", nullable = false, length = 100)
    private User enemy_user_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    public int getBuddy_id() {
        return buddy_id;
    }

    public void setBuddy_id(int buddy_id) {
        this.buddy_id = buddy_id;
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    public User getEnemy_user_id() {
        return enemy_user_id;
    }

    public void setEnemy_user_id(User enemy_user_id) {
        this.enemy_user_id = enemy_user_id;
    }


    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
