package com.exercise_2.Exercise2.service;

import com.exercise_2.Exercise2.model.Owner;
import com.exercise_2.Exercise2.model.Pet;
import com.exercise_2.Exercise2.repository.IOwnerRepository;
import com.exercise_2.Exercise2.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService implements IPetService{

    @Autowired
    private IPetRepository petRepository;

    @Autowired
    private IOwnerRepository ownerRepository;

    @Override
    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet getPetById(Long petId) {
        return petRepository.findById(petId)
                .orElseThrow(()->new RuntimeException("Pet not found"));
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet updatePet(Long petId,
                         String new_petName,
                         String new_species,
                         String new_breed,
                         String new_color,
                         Long new_ownerId) {
        Pet updatedPet = this.getPetById(petId);

        Optional.ofNullable(new_petName).ifPresent(updatedPet::setPetName);
        Optional.ofNullable(new_species).ifPresent(updatedPet::setSpecies);
        Optional.ofNullable(new_breed).ifPresent(updatedPet::setBreed);
        Optional.ofNullable(new_color).ifPresent(updatedPet::setColor);
        ownerRepository.findById(new_ownerId).ifPresent(updatedPet::setOwner);

        return petRepository.save(updatedPet);
    }


    @Override
    public void deletePet(Long petId) {
        petRepository.deleteById(petId);
    }

    @Override
    public List<Pet> getAllPetsBySpeciesAndBreed(String species, String breed) {
        return petRepository.getAllPetsBySpeciesAndBreed(species, breed);
    }
}
