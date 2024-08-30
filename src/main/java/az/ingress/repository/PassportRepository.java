package az.ingress.repository;

import az.ingress.entity.Guide;
import az.ingress.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PassportRepository extends JpaRepository<Passport, Long> {
    Passport findByGuide(Guide guide);
}
