package Team.Gamma.Water_Transport_System.payload.response;

public class LoginMessage {
    private String message;
    private Boolean status;
    private String role;
    private Long userId; // Added userId

    public LoginMessage(String message, Boolean status, String role, Long userId) {
        this.message = message;
        this.status = status;
        this.role = role;
        this.userId = userId; // Initialize userId
    }
    public LoginMessage(String message, boolean status, String role) {
        this.message = message;
        this.status = status;
        this.role = role;
        this.userId = null;
    }

    public LoginMessage(String loginSuccess, boolean b) {

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public Long getUserId() {  // Getter for userId
        return userId;
    }

    public void setUserId(Long userId) {  // Setter for userId
        this.userId = userId;
    }
}
