package com.exercise_2.Exercise2.service;

import com.exercise_2.Exercise2.dto.PetOwnerDTO;
import com.exercise_2.Exercise2.model.Owner;
import com.exercise_2.Exercise2.model.Pet;
import com.exercise_2.Exercise2.repository.IOwnerRepository;
import com.exercise_2.Exercise2.repository.IPetRepository;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService implements IOwnerService{

    @Autowired
    private IOwnerRepository ownerRepository;

    @Autowired
    private IPetRepository petRepository;

    @Override
    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner getOwnerById(Long ownerId) {
        return ownerRepository.findById(ownerId)
                .orElseThrow(()->new RuntimeException("Owner not found"));
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner updateOwner(Long ownerId,
                             String new_ownerDni,
                             String new_ownerName,
                             String new_ownerLastName,
                             String new_phone) {
        Owner owner = this.getOwnerById(ownerId);

        Optional.ofNullable(new_ownerDni).ifPresent(owner::setOwnerDni);
        Optional.ofNullable(new_ownerName).ifPresent(owner::setOwnerName);
        Optional.ofNullable(new_ownerLastName).ifPresent(owner::setOwnerLastName);
        Optional.ofNullable(new_phone).ifPresent(owner::setPhone);

        return ownerRepository.save(owner);
    }

    @Override
    public PetOwnerDTO getPetOwner(Long petId) {

        Pet pet = petRepository.findById(petId)
                .orElseThrow(()->new RuntimeException("Pet not found"));

        Owner owner = Optional.ofNullable(pet.getOwner())
                .map(owner1 -> new Owner (
                        owner1.getOwnerId(),
                        owner1.getOwnerDni(),
                        owner1.getOwnerName(),
                        owner1.getOwnerLastName(),
                        owner1.getPhone(),
                        owner1.getPet()))
                .orElseThrow(()->new RuntimeException("Owner not found"));

        return new PetOwnerDTO(
                pet.getPetName(),
                pet.getSpecies(),
                pet.getBreed(),
                owner.getOwnerName(),
                owner.getOwnerLastName());
    }

    @Override
    public void deleteOwner(Long ownerId) {
        ownerRepository.deleteById(ownerId);
    }
}
