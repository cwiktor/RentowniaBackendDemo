package tech.getarrays.RentowniaBackendDemo.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    @OneToOne
    private Offer offer;
    //enum kategory
    //enum codition




}
