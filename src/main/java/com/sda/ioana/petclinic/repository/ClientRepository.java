package com.sda.ioana.petclinic.repository;

import com.sda.ioana.petclinic.model.Client;
import com.sda.ioana.petclinic.repository.base.BaseRepository;

import java.util.Optional;

public interface ClientRepository extends BaseRepository<Client, Long> {

    Optional<Client> findByName(String firstName, String lastName);
}
