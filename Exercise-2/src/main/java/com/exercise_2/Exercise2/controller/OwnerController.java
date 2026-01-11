package com.exercise_2.Exercise2.controller;

import com.exercise_2.Exercise2.dto.PetOwnerDTO;
import com.exercise_2.Exercise2.model.Owner;
import com.exercise_2.Exercise2.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    private IOwnerService ownerService;

    @GetMapping("/allOwners")
    @ResponseBody
    private List<Owner> getAllOwners(){
        return ownerService.getAllOwners();
    }

    @GetMapping("/owner")
    @ResponseBody
    private Owner getOwnerById(@RequestParam Long ownerId){
        return ownerService.getOwnerById(ownerId);
    }

    @GetMapping("/owner/getPetOwner")
    @ResponseBody
    private PetOwnerDTO getPetOwner(@RequestParam Long petId){
        return ownerService.getPetOwner(petId);
    }

    @PostMapping("/owner/create")
    @ResponseBody
    private Owner createOwner(@RequestBody Owner owner){
        return ownerService.createOwner(owner);
    }

    @PutMapping("/owner/update")
    @ResponseBody
    private Owner updateOwner(@RequestParam Long ownerId,
                              @RequestParam(required = false, name = "ownerDni") String new_ownerDni,
                              @RequestParam(required = false, name = "ownerName") String new_ownerName,
                              @RequestParam(required = false, name = "ownerLastName") String new_ownerLastName,
                              @RequestParam(required = false, name = "phone") String new_phone){
        return ownerService.updateOwner(ownerId, new_ownerDni, new_ownerName, new_ownerLastName, new_phone);
    }

    @DeleteMapping("/owner/delete")
    private void deleteOwner(@RequestParam Long ownerId){
        ownerService.deleteOwner(ownerId);
    }

}
