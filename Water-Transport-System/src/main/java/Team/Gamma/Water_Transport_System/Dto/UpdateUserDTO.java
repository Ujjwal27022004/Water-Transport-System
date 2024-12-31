package Team.Gamma.Water_Transport_System.Dto;

public class UpdateUserDTO {
    private String username;
    private String email;
    private String password;

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }



    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
