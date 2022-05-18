package com.sda.ioana.petclinic.repository;

import com.sda.ioana.petclinic.model.Pet;
import com.sda.ioana.petclinic.repository.base.BaseRepositoryImpl;

public class PetRepositoryImpl extends BaseRepositoryImpl<Pet, Long> implements  PetRepository{

    public PetRepositoryImpl() {
        super(Pet.class);
    }



}
