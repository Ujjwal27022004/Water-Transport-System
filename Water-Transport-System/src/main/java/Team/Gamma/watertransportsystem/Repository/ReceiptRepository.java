package Team.Gamma.watertransportsystem.Repository;
import  Team.Gamma.watertransportsystem.Entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Receipt findByUserId(Long userId);
}
