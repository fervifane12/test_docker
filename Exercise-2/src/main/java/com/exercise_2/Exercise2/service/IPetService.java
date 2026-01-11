package com.exercise_2.Exercise2.service;

import com.exercise_2.Exercise2.model.Pet;

import java.util.List;

public interface IPetService {
    Pet createPet(Pet pet);
    Pet getPetById(Long petId);
    List<Pet> getAllPets();
    Pet updatePet(Long petId,
                  String new_petName,
                  String new_species,
                  String new_breed,
                  String new_color,
                  Long new_ownerId);
    void deletePet(Long petId);
    List<Pet> getAllPetsBySpeciesAndBreed(String species, String breed);
}