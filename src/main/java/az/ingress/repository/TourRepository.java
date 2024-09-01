package az.ingress.repository;

import az.ingress.entity.Tour;
import az.ingress.entity.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    @Query("select t from Tour t " +
            "join fetch t.destinations d " +
            "join fetch t.guides g " +
            "join fetch g.passport p " +
            "join fetch t.travelers tr"
    )
    List<Tour> findAll();


    Set<Tour> findByTravelers(Traveler traveler);
}