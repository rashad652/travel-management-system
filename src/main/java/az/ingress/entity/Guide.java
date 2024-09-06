package az.ingress.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;

    @JsonIgnore
    @ManyToMany(mappedBy = "guides")
    private Set<Tour> tours;

    @OneToOne(mappedBy = "guide",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Passport passport;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guide)) return false;
        Guide guide = (Guide) o;
        return Objects.equals(id, guide.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}