package spring.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Damian Stępniak on 01.04.2017.
 */
@Entity
public class Buddy implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int buddy_id;

    @Id
    @Column(name = "ENEMY_USER_ID", nullable = false, length = 100)
    private int enemy_user_id;

    @Id
    @Column(name = "USER_ID", nullable = false)
    private int user_id;

    public int getBuddy_id() {
        return buddy_id;
    }

    public void setBuddy_id(int buddy_id) {
        this.buddy_id = buddy_id;
    }

    public int getEnemy_user_id() {
        return enemy_user_id;
    }

    public void setEnemy_user_id(int enemy_user_id) {
        this.enemy_user_id = enemy_user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
