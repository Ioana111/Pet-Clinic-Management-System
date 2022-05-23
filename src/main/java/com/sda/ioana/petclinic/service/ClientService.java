package com.sda.ioana.petclinic.service;

import com.sda.ioana.petclinic.model.Pet;

import java.util.Arrays;
import java.util.List;

public interface ClientService {

    List<Pet> findPetsForClientId(Long clientId);

}
