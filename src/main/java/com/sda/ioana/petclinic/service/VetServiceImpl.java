package com.sda.ioana.petclinic.service;

import com.sda.ioana.petclinic.model.Vet;
import com.sda.ioana.petclinic.repository.VetRepository;
import com.sda.ioana.petclinic.repository.VetRepositoryImpl;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;

    public VetServiceImpl() {
        this.vetRepository = new VetRepositoryImpl();
    }

    @Override
    public void create(
            String firstName,
            String lastName,
            String address,
            String speciality) throws InvalidParameterException {
        //ca sa fie si mai smart vom face validare pe datele primite
        if(firstName == null || firstName.isBlank()) {
            throw new InvalidParameterException("First name is null or empty.");
        }
        if(lastName == null || lastName.isBlank()) {
            throw new InvalidParameterException("Last name is null or empty.");
        }
        if(address == null || address.isBlank()) {
            throw new InvalidParameterException("Address is null or empty.");
        }
        if(speciality == null || speciality.isBlank()) {
            throw new InvalidParameterException("Speciality is null or empty.");
        }
        vetRepository.create(new Vet(firstName, lastName, address, speciality));

    }








}
