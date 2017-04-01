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

    @Column(name = "ENEMY_USER_ID", nullable = false, length = 100)
    private int enemy_user_id;

    @Column(name = "USER_ID", nullable = false)
    private int user_id;

}
