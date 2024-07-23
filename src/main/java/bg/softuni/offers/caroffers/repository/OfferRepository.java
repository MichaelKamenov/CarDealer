package bg.softuni.offers.caroffers.repository;


import bg.softuni.offers.caroffers.model.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
}
