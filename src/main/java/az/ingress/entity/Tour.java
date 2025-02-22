package az.ingress.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static javax.persistence.CascadeType.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "tour",
            cascade = {PERSIST, MERGE},
            orphanRemoval = true)
    private List<Destination> destinations = new ArrayList<>();

    @ManyToMany(cascade = {PERSIST, MERGE})
    @JoinTable(
            name = "tour_guide",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "guide_id")
    )
    private Set<Guide> guides = new HashSet<>();

    @ManyToMany(cascade = {PERSIST, MERGE})
    @JoinTable(
            name = "tour_traveler",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "traveler_id")
    )
    private Set<Traveler> travelers = new HashSet<>();
}