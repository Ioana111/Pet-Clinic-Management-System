package com.sda.ioana.petclinic.repository;

import com.sda.ioana.petclinic.model.Consult;
import com.sda.ioana.petclinic.repository.base.BaseRepository;

import java.util.Date;
import java.util.List;

public interface ConsultRepository extends BaseRepository<Consult, Long> {

    List<Consult> findAllUnvaccinatedPets();

    List<Consult> findAllByVetIdAndDateBetween(Long vetId, Date startDate, Date endDate);
}
