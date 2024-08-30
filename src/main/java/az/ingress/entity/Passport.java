package az.ingress.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;
    private Date issueDate;
    private Date expiryDate;
    private String country;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "guide_id")
    private Guide guide;
}