package az.ingress.repository;
import az.ingress.entity.Destination;
import az.ingress.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findByTour(Tour tour);
}