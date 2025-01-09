package Team.Gamma.water_transport_system.Service;

import Team.Gamma.water_transport_system.Entity.Receipt;

public interface ReceiptService {
    public Receipt generateReceipt(Long userId);
}
