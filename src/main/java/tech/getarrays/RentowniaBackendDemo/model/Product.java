package tech.getarrays.RentowniaBackendDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToOne(mappedBy = "product")
    private Offer offer;
    //enum kategory
    //enum codition

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }





}
