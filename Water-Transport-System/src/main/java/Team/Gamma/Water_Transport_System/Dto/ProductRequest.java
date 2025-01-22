package Team.Gamma.Water_Transport_System.Dto;

public class ProductRequest {
    private Long amount;
    private Long quantity;
    private String name;
    private String currency;
    private  String successUrl;
    private String cancelUrl;
    // Default Constructor
    public ProductRequest() {
    }

    // Parameterized Constructor
    public ProductRequest(Long amount, Long quantity, String name, String currency,String successUrl , String cancelUrl) {
        this.amount = amount;
        this.quantity = quantity;
        this.name = name;
        this.currency = currency;
        this.successUrl = successUrl;
        this.cancelUrl = cancelUrl;
    }

    // Getters and Setters
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    // toString Method
    @Override
    public String toString() {
        return "ProductRequest{" +
                "amount=" + amount +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
