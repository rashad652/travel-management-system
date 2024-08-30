package az.ingress.service;

import az.ingress.entity.Traveler;
import az.ingress.repository.TourRepository;
import az.ingress.repository.TravelerRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import az.ingress.entity.Tour;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TravelerService {

    private final TravelerRepository travelerRepository;
    private final TourRepository tourRepository;

    public Traveler createTraveler(Traveler traveler) {
        return travelerRepository.save(traveler);
    }

    @SneakyThrows
    public Traveler getTravelerById(Long id) {
        return travelerRepository.findById(id).orElseThrow(() -> new Exception("Traveler not found"));
    }

    public List<Traveler> getAllTravelers() {
        return travelerRepository.findAll();
    }

    public void addTravelerToTour(Long travelerId, Long tourId) throws Exception {
        Traveler traveler = getTravelerById(travelerId);
        Tour tour = tourRepository.findById(tourId).orElseThrow(() -> new Exception("Tour not found"));
        tour.getTravelers().add(traveler);
        tourRepository.save(tour);
    }

    public Set<Tour> getToursForTraveler(Long travelerId) {
        Traveler traveler = getTravelerById(travelerId);
        return tourRepository.findByTravelers(traveler);
    }
}