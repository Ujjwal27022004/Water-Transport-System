package Team.Gamma.water_transport_system.Repository;
import  Team.Gamma.water_transport_system.Entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Receipt findByUserId(Long userId);
}
