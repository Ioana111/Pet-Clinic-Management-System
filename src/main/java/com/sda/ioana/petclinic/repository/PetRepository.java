package com.sda.ioana.petclinic.repository;

import com.sda.ioana.petclinic.model.Pet;
import com.sda.ioana.petclinic.repository.base.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends BaseRepository<Pet, Long> {

    List<Pet> findAllVaccinated();
    //List<Pet> findAllPets();

}
