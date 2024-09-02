package az.ingress.controller;

import az.ingress.entity.Passport;
import az.ingress.service.GuideService;
import az.ingress.entity.Guide;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/guides")
public class GuideController {

    private final GuideService guideService;

    @PostMapping
    public ResponseEntity<Guide> createGuide(@RequestBody Guide guide) {
        return ResponseEntity.ok(guideService.createGuide(guide));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guide> getGuide(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(guideService.getGuideById(id));
    }

    @GetMapping
    public ResponseEntity<List<Guide>> getAllGuides() {
        return ResponseEntity.ok(guideService.getAllGuides());
    }

    @PostMapping("/{guideId}/assign-tour/{tourId}")
    public ResponseEntity<Void> assignGuideToTour(@PathVariable Long guideId, @PathVariable Long tourId) throws Exception {
        guideService.assignGuideToTour(guideId, tourId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/passport")
    public ResponseEntity<Passport> getPassportForGuide(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(guideService.getPassportForGuide(id));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Guide>> getAllAvailableGuides(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                             @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return ResponseEntity.ok(guideService.getAllAvailableGuides(from, to));
    }
}