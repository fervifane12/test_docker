package com.exercise_2.Exercise2.controller;

import com.exercise_2.Exercise2.model.Pet;
import com.exercise_2.Exercise2.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private IPetService petService;

    @GetMapping("/allPets")
    @ResponseBody
    private List<Pet> getAllPets(){
        return petService.getAllPets();
    }

    @GetMapping("/pet")
    @ResponseBody
    private Pet getPetById(@RequestParam Long petId){
        return petService.getPetById(petId);
    }

    @GetMapping("/pet/{species}/{breed}")
    @ResponseBody
    private List<Pet> getAllPetsBySpeciesAndBreed(@PathVariable String species,
                                                  @PathVariable String breed){
        return petService.getAllPetsBySpeciesAndBreed(species, breed);
    }

    @PostMapping("/pet/create")
    @ResponseBody
    private Pet createPet(@RequestBody Pet pet){
        return petService.createPet(pet);
    }

    @PutMapping("/pet/update")
    @ResponseBody
    private Pet updatePet(@RequestParam Long petId,
                          @RequestParam(required = false, name = "petName") String new_petName,
                          @RequestParam(required = false, name = "species") String new_species,
                          @RequestParam(required = false, name = "breed") String new_breed,
                          @RequestParam(required = false, name = "color") String new_color,
                          @RequestParam(required = false, name = "ownerId") Long new_ownerId){
        return petService.updatePet(petId, new_petName, new_species, new_breed, new_color, new_ownerId);
    }

    @DeleteMapping("/pet/delete")
    private ResponseEntity<String> deletePet(@RequestParam Long petId){
        petService.deletePet(petId);
        return new ResponseEntity<>("The pet was deleted successfully", HttpStatus.OK);
    }

}
