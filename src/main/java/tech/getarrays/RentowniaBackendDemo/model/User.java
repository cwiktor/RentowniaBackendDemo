package tech.getarrays.RentowniaBackendDemo.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User extends Person{

    private String number;
    private int loyaltyLevel;
    private String avatarUrl;
    //private Address address;

    public User() {
    }

    public User(String name, String lastName, String email, String number, int loyaltyLevel, String avatarUrl) {
        super(name, lastName, email);
        this.number = number;
        this.loyaltyLevel = loyaltyLevel;
        this.avatarUrl = avatarUrl;
    }
}
