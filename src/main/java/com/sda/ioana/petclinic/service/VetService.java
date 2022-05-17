package com.sda.ioana.petclinic.service;

import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

public interface VetService {

    void create(String firstName,
                String lastName,
                String address,
                String speciality) throws InvalidParameterException;

}
