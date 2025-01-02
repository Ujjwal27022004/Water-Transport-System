package Team.Gamma.Water_Transport_System.Dto;

public class AdminDTO {
    private Long adminId;
    private String password;
    private String email;

    //Getter and Setter
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
    public String getEmailId() {
        return email;
    }

    public void setEmailId(String emailId) {
        this.email = emailId;
    }
}
