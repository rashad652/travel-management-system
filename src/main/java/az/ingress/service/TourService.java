package az.ingress.service;

import az.ingress.entity.Destination;

import az.ingress.entity.Guide;
import az.ingress.entity.Tour;
import az.ingress.entity.Traveler;
import az.ingress.repository.DestinationRepository;
import az.ingress.repository.GuideRepository;
import az.ingress.repository.TourRepository;
import az.ingress.repository.TravelerRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {

    private final TourRepository tourRepository;
    private final DestinationRepository destinationRepository;
    private final TravelerRepository travelerRepository;
    private final GuideRepository guideRepository;

    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
    }

    @SneakyThrows
    public Tour getTourById(Long id) throws Exception {
        return tourRepository.findById(id).orElseThrow(() -> new Exception("Tour not found"));
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @SneakyThrows
    public List<Destination> getDestinationsForTour(Long tourId) {
        Tour tour = getTourById(tourId);
        return destinationRepository.findByTour(tour);
    }

    @SneakyThrows
    public List<Traveler> getTravelersForTour(Long tourId) {
        Tour tour = getTourById(tourId);
        return travelerRepository.findByTours(tour);
    }

    public List<Guide> getGuidesForTour(Long tourId) throws Exception {
        Tour tour = getTourById(tourId);
        return guideRepository.findByTours(tour);
    }
}
