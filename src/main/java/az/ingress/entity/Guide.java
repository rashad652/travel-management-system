package az.ingress.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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

}