package Team.Gamma.Water_Transport_System.Repository;
import  Team.Gamma.Water_Transport_System.Entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Receipt findByUserId(Long userId);
}
