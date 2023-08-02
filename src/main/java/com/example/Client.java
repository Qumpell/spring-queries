package com.example;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clients",uniqueConstraints = {@UniqueConstraint(columnNames = {"peselNumber"})})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String peselNumber;

//    @OneToOne(cascade = CascadeType.ALL)
//private Address address;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Set<Address> addressSet;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressSet=" + addressSet.toString() +
                '}';
    }

//    @PreRemove
//    public void removeAddressAssociations(){
//        this.addressSet.forEach(addr -> this.addressSet.remove(addr));
//    }
}
