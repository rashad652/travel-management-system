package az.ingress.controller;

import az.ingress.entity.Tour;
import az.ingress.entity.Traveler;
import az.ingress.service.TravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/api/travelers")
public class TravelerController {

    private final TravelerService travelerService;

    @PostMapping
    public ResponseEntity<Traveler> createTraveler(@RequestBody Traveler traveler) {
        return ResponseEntity.ok(travelerService.createTraveler(traveler));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Traveler> getTraveler(@PathVariable Long id) {
        return ResponseEntity.ok(travelerService.getTravelerById(id));
    }

    @GetMapping
    public ResponseEntity<List<Traveler>> getAllTravelers() {
        return ResponseEntity.ok(travelerService.getAllTravelers());
    }

    @PostMapping("/{travelerId}/join-tour/{tourId}")
    public ResponseEntity<Void> addTravelerToTour(@PathVariable Long travelerId, @PathVariable Long tourId) throws Exception {
        travelerService.addTravelerToTour(travelerId, tourId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/tours")
    public ResponseEntity<Set<Tour>> getToursForTraveler(@PathVariable Long id) {
        return ResponseEntity.ok(travelerService.getToursForTraveler(id));
    }
}
