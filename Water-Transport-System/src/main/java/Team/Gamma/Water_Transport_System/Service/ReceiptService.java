package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Entity.Receipt;

public interface ReceiptService {
    public Receipt generateReceipt(Long userId);
}
