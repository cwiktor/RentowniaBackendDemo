package tech.getarrays.RentowniaBackendDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Offer> offers = new ArrayList<>();

    public User() {
    }

    public User(String name, String lastName, String email, String number, int loyaltyLevel, String avatarUrl) {
        super(name, lastName, email);
        this.number = number;
        this.loyaltyLevel = loyaltyLevel;
        this.avatarUrl = avatarUrl;
    }
}
