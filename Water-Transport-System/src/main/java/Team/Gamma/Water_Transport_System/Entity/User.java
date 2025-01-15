package Team.Gamma.Water_Transport_System.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")

public class User extends Person {
    @Id
    @Column(name = "user_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @Column(name = "username", length = 255)
    private String username;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "password", length = 255)
    private String password;


    //Getter and setter

    public Long getUserid() {
        return userid;
    }



    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //constructor
    public User() {
    }
    public User(Long userid,String username, String email, String password) {
        this.userid = userid;

        this.username = username;
        this.email = email;
        this.password = password;
    }
}

