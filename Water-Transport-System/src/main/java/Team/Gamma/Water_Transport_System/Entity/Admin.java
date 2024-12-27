package Team.Gamma.Water_Transport_System.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admindata")
public class Admin {
    @Id
    private Long adminId;

    private String password;

    // Default constructor is required by JPA
    public Admin() {
    }

    public Admin(String password, Long adminId) {
        this.password = password;
        this.adminId = adminId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
