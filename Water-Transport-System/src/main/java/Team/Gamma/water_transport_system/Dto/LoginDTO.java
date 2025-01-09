package Team.Gamma.water_transport_system.Dto;

public class LoginDTO {
    private String email;
    private String password;


    //Getter and Setter
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //constructor
    public LoginDTO() {
    }
    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}