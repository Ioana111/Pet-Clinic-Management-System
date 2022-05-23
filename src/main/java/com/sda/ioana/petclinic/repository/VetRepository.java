package com.sda.ioana.petclinic.repository;

import com.sda.ioana.petclinic.model.Vet;
import com.sda.ioana.petclinic.repository.base.BaseRepository;

import java.util.List;

public interface VetRepository extends BaseRepository<Vet, Long> {

    /**

     *         private String firstName;
     *         private String lastName;
     *         private String address;
     *         private String speciality;
     */

    List<Vet> findByMultipleParameters(String firstName, String lastName, String address, String speciality);
}
