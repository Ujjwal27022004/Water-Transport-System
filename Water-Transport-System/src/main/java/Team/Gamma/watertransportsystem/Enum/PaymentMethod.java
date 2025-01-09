package Team.Gamma.watertransportsystem.Enum;

public enum PaymentMethod {
    UPI("Unified Payments Interface"),
    CREDIT_DEBIT_CARD("Credit/Debit Card"),
    PAYPAL("PayPal"),
    NETBANKING("Net Banking");

    private final String description;

    PaymentMethod(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
