package az.ingress.repository;

import az.ingress.entity.Tour;
import az.ingress.entity.Traveler;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    @Override
    @EntityGraph(attributePaths = {"destinations", "guides", "travelers", "guides.passport"})
    List<Tour> findAll();


    Set<Tour> findByTravelers(Traveler traveler);
}