package az.ingress.repository;

import az.ingress.entity.Tour;
import az.ingress.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelerRepository extends JpaRepository<Traveler, Long> {

    List<Traveler> findByTours(Tour tour);
}