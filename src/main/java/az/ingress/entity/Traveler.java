package az.ingress.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Traveler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @JsonIgnore
    @ManyToMany(mappedBy = "travelers")
    private Set<Tour> tours = new HashSet<>();

}