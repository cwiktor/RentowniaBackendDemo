package tech.getarrays.RentowniaBackendDemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class User extends Person{

    private String number;
    private int loyaltyLevel;
    private String avatarUrl;
    @OneToOne
    private Address address;
    @OneToMany(targetEntity = Offer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "uo_fk", referencedColumnName = "id")
    private List<Offer> offers = new ArrayList();

    public User() {
    }

    public User(String name, String lastName, String email, String number, int loyaltyLevel, String avatarUrl) {
        super(name, lastName, email);
        this.number = number;
        this.loyaltyLevel = loyaltyLevel;
        this.avatarUrl = avatarUrl;
    }
}
