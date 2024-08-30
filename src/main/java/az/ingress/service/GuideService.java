package az.ingress.service;

import az.ingress.entity.Guide;
import az.ingress.entity.Passport;
import az.ingress.entity.Tour;
import az.ingress.repository.GuideRepository;
import az.ingress.repository.PassportRepository;
import az.ingress.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuideService {

    private final GuideRepository guideRepository;

    private final TourRepository tourRepository;

    private final PassportRepository passportRepository;


    public Guide createGuide(Guide guide) {
        return guideRepository.save(guide);
    }

    public Guide getGuideById(Long id) throws Exception {
        return guideRepository.findById(id).orElseThrow(() -> new Exception("Guide not found"));
    }

    public List<Guide> getAllGuides() {
        return guideRepository.findAll();
    }

    public List<Guide> getAllAvailableGuides(LocalDate startDate, LocalDate endDate) {
        return guideRepository.findAvailableGuides(startDate, endDate);
    }

    public void assignGuideToTour(Long guideId, Long tourId) throws Exception {
        Guide guide = getGuideById(guideId);
        Tour tour = tourRepository.findById(tourId).orElseThrow(() -> new Exception("Tour not found"));

        // Check if guide is already booked for another tour during the same dates
        for (Tour existingTour : guide.getTours()) {
            if (datesOverlap(existingTour.getStartDate(), existingTour.getEndDate(), tour.getStartDate(), tour.getEndDate())) {
                throw new Exception("Guide is already booked for another tour during these dates");
            }
        }

        tour.getGuides().add(guide);
        tourRepository.save(tour);
    }

    private boolean datesOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return !start1.isAfter(end2) && !start2.isAfter(end1);
    }

    public Passport getPassportForGuide(Long guideId) throws Exception {
        Guide guide = getGuideById(guideId);
        return passportRepository.findByGuide(guide);
    }
}
