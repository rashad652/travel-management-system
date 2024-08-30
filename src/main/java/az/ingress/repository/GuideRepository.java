package az.ingress.repository;

import az.ingress.entity.Guide;
import az.ingress.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface GuideRepository extends JpaRepository<Guide, Long> {
    @Query("SELECT g FROM Guide g WHERE NOT EXISTS (" +
            "SELECT 1 FROM Tour t JOIN t.guides tg WHERE tg.id = g.id AND " +
            "(t.startDate <= :endDate AND t.endDate >= :startDate))")
    List<Guide> findAvailableGuides(LocalDate startDate, LocalDate endDate);

    List<Guide> findByTours(Tour tour);
}
