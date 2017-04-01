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

    @Id
    @Column(name = "ENEMY_USER_ID", nullable = false, length = 100)
    private User enemy_user_id;

    @Id
    @Column(name = "USER_ID", nullable = false)
    private User user_id;


}
