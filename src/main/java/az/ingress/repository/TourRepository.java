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

    @Override
    @Query("select distinct t from Tour t " +
            "left join fetch t.destinations d " +
            "left join fetch t.travelers tr " +
            "left join fetch t.guides g " +
            "left join fetch g.passport p"
    )
    List<Tour> findAll();

    Set<Tour> findByTravelers(Traveler traveler);
}