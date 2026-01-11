package com.exercise_2.Exercise2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetOwnerDTO {
    private String petName;
    private String species;
    private String breed;
    private String ownerName;
    private String ownerLastName;
}
