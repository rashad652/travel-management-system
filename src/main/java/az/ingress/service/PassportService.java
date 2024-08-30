package az.ingress.service;

import az.ingress.entity.Passport;
import az.ingress.repository.PassportRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassportService {

    private final PassportRepository passportRepository;

    public Passport createPassport(Passport passport) {
        return passportRepository.save(passport);
    }

    @SneakyThrows
    public Passport getPassportById(Long id) {
        return passportRepository.findById(id).orElseThrow(() -> new Exception("Passport not found"));
    }
}