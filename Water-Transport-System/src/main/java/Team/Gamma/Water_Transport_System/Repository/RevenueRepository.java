    package Team.Gamma.Water_Transport_System.Repository;

    import Team.Gamma.Water_Transport_System.Entity.Bookings;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;

    public interface RevenueRepository extends JpaRepository<Bookings,Long> {

            @Query("SELECT COUNT(b) FROM Bookings b WHERE b.ship.shipId = :shipId")
            int countByShipId(@Param("shipId") int shipId);

            @Query("SELECT SUM(b.totalPrice) FROM Bookings b WHERE b.ship.shipId = :shipId")
            Integer sumTotalPriceByShipId(@Param("shipId") int shipId);
        }



