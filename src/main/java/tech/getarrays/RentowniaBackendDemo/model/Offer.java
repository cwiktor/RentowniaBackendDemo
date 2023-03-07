package tech.getarrays.RentowniaBackendDemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private LocalDate dateFrom;
    private LocalDate dateTo;
    @OneToOne
    private Product product;
    @ManyToOne
    private User user;

    public Offer() {
    }

    public Offer(LocalDate dateFrom, LocalDate dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
