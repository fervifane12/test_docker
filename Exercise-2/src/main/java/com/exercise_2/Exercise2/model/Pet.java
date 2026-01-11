package com.exercise_2.Exercise2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long petId;
    private String petName;
    private String species;
    private String breed;
    private String color;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "ownerId")
    @JsonBackReference
    private Owner owner;
}