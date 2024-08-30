package az.ingress.service;

import az.ingress.entity.Destination;
import az.ingress.repository.DestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DestinationService {
    private final DestinationRepository destinationRepository;

    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    public Destination getDestinationById(Long id) throws Exception {
        return destinationRepository.findById(id).orElseThrow(() -> new Exception("Destination not found"));
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }
}
