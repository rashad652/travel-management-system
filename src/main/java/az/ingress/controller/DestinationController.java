package az.ingress.controller;

import az.ingress.entity.Destination;
import az.ingress.service.DestinationService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/destinations")
public class DestinationController {


    private final DestinationService destinationService;

    @PostMapping
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination) {
        return ResponseEntity.ok(destinationService.createDestination(destination));
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestination(@PathVariable Long id) {
        return ResponseEntity.ok(destinationService.getDestinationById(id));
    }

    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations() {
        return ResponseEntity.ok(destinationService.getAllDestinations());
    }
}