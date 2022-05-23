package com.sda.ioana.petclinic.service;

import com.sda.ioana.petclinic.model.Client;
import com.sda.ioana.petclinic.model.Pet;
import com.sda.ioana.petclinic.service.dto.PetDto;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.List;

public interface PetService {

    void create(
            String race,
            Date dateOfBirth,
            boolean isVaccinated,
            String ownerFirstName,
            String ownerLastName
    ) throws InvalidParameterException;

    List<Pet> findAllVaccinated();

    List<PetDto> showAll();

    void deletePetById(Long id);

    void updatePetById(Long id,
                       String race,
                       Date dateOfBirth,
                       boolean isVaccinated
                     ) throws InvalidParameterException;
}
