package com.sda.ioana.petclinic.service;

import com.sda.ioana.petclinic.repository.ConsultRepository;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

import java.util.Date;

public interface ConsultService {

    void create(Date date, String description, Long vetId, Long PetId) throws InvalidParameterException;

}
