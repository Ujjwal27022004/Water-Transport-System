package Team.Gamma.Water_Transport_System.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")

public class User {
    @Id
    @Column(name = "user_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Query> queries;
    @Column(name = "username", length = 255)
    private String username;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "password", length = 255)
    private String password;

    public User() {
    }

    public User(Long userid, List<Query> queries, String username, String email, String password) {
        this.userid = userid;
        this.queries = queries;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getUserid() {
        return userid;
    }

    public List<Query> getQueries() {
        return queries;
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

    public void setQueries(List<Query> queries) {
        this.queries = queries;
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
}

