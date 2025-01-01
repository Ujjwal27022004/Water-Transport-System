package Team.Gamma.Water_Transport_System.Dto;

public class UserDTO {
    private Long userid;
    private String username;
    private String email;
    private String password;


    //Getter and Setter

    public Long getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    //Constructor
    public UserDTO() {
    }
    public UserDTO(Long userid, String username, String email, String password) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

