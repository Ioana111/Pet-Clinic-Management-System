package com.sda.ioana.petclinic.service;

import com.sda.ioana.petclinic.model.Consult;
import com.sda.ioana.petclinic.repository.ConsultRepository;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.List;

public interface ConsultService {

    void create(Date date, String description, Long vetId, Long PetId) throws InvalidParameterException;
    List<Consult> findAllUnvaccinatedPets();
    List<Consult> findAllByVetIdAndDateBetween(Long vetId, Date startDate, Date endDate) throws InvalidParameterException;

}
