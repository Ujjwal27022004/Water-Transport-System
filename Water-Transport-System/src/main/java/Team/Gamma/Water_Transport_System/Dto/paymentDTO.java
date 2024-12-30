package Team.Gamma.Water_Transport_System.Dto;

public class paymentDTO {
    private String message;
    private boolean success;

    public paymentDTO(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
