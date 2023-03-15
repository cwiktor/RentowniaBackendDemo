package tech.getarrays.RentowniaBackendDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.getarrays.RentowniaBackendDemo.model.Offer;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    Optional<Offer> getOfferById(Long id);
}
