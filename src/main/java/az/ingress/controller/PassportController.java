package az.ingress.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import az.ingress.entity.Passport;
import az.ingress.service.PassportService;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/passports")
public class PassportController {

    private final PassportService passportService;

    @PostMapping
    public ResponseEntity<Passport> createPassport(@RequestBody Passport passport) {
        return ResponseEntity.ok(passportService.createPassport(passport));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passport> getPassport(@PathVariable Long id) {
        return ResponseEntity.ok(passportService.getPassportById(id));
    }
}