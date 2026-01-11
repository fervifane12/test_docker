package com.exercise_2.Exercise2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ownerId;
    private String ownerDni;
    private String ownerName;
    private String ownerLastName;
    private String phone;
    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    private List<Pet> pet;
}
