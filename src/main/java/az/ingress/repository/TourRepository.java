package az.ingress.repository;

import az.ingress.entity.Tour;
import az.ingress.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    Set<Tour> findByTravelers(Traveler traveler);
}