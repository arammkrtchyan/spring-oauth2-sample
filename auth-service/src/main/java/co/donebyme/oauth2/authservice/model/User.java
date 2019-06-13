package co.donebyme.oauth2.authservice.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Aram Mkrtchyan.
 */
@Entity
@Table(name = "user_details")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
