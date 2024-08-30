package az.ingress.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Traveler)) return false;
        Traveler traveler = (Traveler) o;
        return Objects.equals(id, traveler.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}