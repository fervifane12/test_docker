package com.exercise_2.Exercise2.service;

import com.exercise_2.Exercise2.dto.PetOwnerDTO;
import com.exercise_2.Exercise2.model.Owner;

import java.util.List;

public interface IOwnerService {
    Owner createOwner(Owner owner);
    Owner getOwnerById(Long ownerId);
    List<Owner> getAllOwners();
    Owner updateOwner(Long ownerId,
                      String new_ownerDni,
                      String new_ownerName,
                      String new_ownerLastName,
                      String new_phone);
    PetOwnerDTO getPetOwner(Long petId);
    void deleteOwner(Long ownerId);
}
