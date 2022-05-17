package com.sda.ioana.petclinic.service;

import com.sda.ioana.petclinic.service.dto.VetDto;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

import java.util.List;

public interface VetService {

    void create(String firstName,
                String lastName,
                String address,
                String speciality) throws InvalidParameterException;

    //DTO = data tranfer obj
    List<VetDto> findAll();

    void deleteById(Long id);

}
