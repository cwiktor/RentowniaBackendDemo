package tech.getarrays.RentowniaBackendDemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String lastName;
    private String email;

    public Person() {
    }

    public Person(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }


}
