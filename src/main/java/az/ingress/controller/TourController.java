package az.ingress.controller;

import az.ingress.entity.Destination;
import az.ingress.entity.Guide;
import az.ingress.entity.Tour;
import az.ingress.entity.Traveler;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import az.ingress.service.TourService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/tours")
public class TourController {

    private final TourService tourService;

    @PostMapping
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        return ResponseEntity.ok(tourService.createTour(tour));
    }

    @GetMapping("/{id}")
    @SneakyThrows
    public ResponseEntity<Tour> getTour(@PathVariable Long id) {
        return ResponseEntity.ok(tourService.getTourById(id));
    }

    @GetMapping
    public ResponseEntity<List<Tour>> getAllTours() {
        return ResponseEntity.ok(tourService.getAllTours());
    }

    @GetMapping("/{id}/destinations")
    public ResponseEntity<List<Destination>> getDestinationsForTour(@PathVariable Long id) {
        return ResponseEntity.ok(tourService.getDestinationsForTour(id));
    }

    @GetMapping("/{id}/travelers")
    public ResponseEntity<List<Traveler>> getTravelersForTour(@PathVariable Long id) {
        return ResponseEntity.ok(tourService.getTravelersForTour(id));
    }

    @GetMapping("{id}/guides")
    public ResponseEntity<List<Guide>> getToursForGuide(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(tourService.getGuidesForTour(id));
    }
}
