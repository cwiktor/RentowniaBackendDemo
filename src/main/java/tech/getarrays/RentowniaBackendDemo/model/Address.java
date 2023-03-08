package tech.getarrays.RentowniaBackendDemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String country;
    private String city;
    private String ZipCode;
    private String Street;
    private String number;
    @OneToOne
    private User user;

    public Address() {
    }

    public Address(String country, String city, String zipCode, String street, String number) {
        this.country = country;
        this.city = city;
        ZipCode = zipCode;
        Street = street;
        this.number = number;
    }
}
