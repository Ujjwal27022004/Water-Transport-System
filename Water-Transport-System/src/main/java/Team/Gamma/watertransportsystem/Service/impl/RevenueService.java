package Team.Gamma.watertransportsystem.Service.impl;

import Team.Gamma.watertransportsystem.Repository.RevenueRepository;
import Team.Gamma.watertransportsystem.Service.RevenueCalc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RevenueService implements RevenueCalc {

    private final RevenueRepository revenueRepository;

    @Value("${ship.static.price:1000}")
    private int shipPrice;

    public RevenueService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public int calculateTotalprice(int shipId) {
        Integer totalRevenue = revenueRepository.sumTotalPriceByShipId(shipId);
        return totalRevenue != null ? totalRevenue : 0;
    }
}
