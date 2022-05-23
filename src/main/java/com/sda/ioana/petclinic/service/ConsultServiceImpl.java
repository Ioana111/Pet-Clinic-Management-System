package com.sda.ioana.petclinic.service;


import com.sda.ioana.petclinic.model.Consult;
import com.sda.ioana.petclinic.model.Pet;
import com.sda.ioana.petclinic.model.Vet;
import com.sda.ioana.petclinic.repository.*;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.Optional;

public class ConsultServiceImpl implements ConsultService {

    private final ConsultRepository consultRepository;
    private final PetRepository petRepository;
    private final VetRepository vetRepository;


    public ConsultServiceImpl() {
        this.consultRepository = new ConsultRepositoryImpl();
        this.petRepository = new PetRepositoryImpl();
        this.vetRepository = new VetRepositoryImpl();
    }

    @Override
    public void create(Date date, String description, Long vetId, Long petId) throws InvalidParameterException {
        if (date == null) {
            throw new InvalidParameterException("Date of consult is null.");
        }
        if (description == null || description.isBlank()) {
            throw new InvalidParameterException("Description is null or empty.");
        }

        if(vetId == null){
            throw new InvalidParameterException("Vet Id is null");
        }
        if(petId == null){
            throw new InvalidParameterException("Pet Id is null");
        }

        Optional<Pet> petFromDB = petRepository.findById(petId);
        Optional<Vet> vetFromDB = vetRepository.findById(vetId);

        if (petFromDB.isEmpty()) {
            throw new InvalidParameterException("Invalid pet id. Please select an existing pet!");
        }
        if (vetFromDB.isEmpty()) {
            throw new InvalidParameterException("Invalid vet id. Please select an existing vet!");

        }

        Consult consult = new Consult(date, description);
        consult.setPet(petFromDB.get());
        consult.setVet(vetFromDB.get());
        consultRepository.create(consult);
    }


}

