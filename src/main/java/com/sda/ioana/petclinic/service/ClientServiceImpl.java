package com.sda.ioana.petclinic.service;

import com.sda.ioana.petclinic.model.Client;
import com.sda.ioana.petclinic.model.Pet;
import com.sda.ioana.petclinic.repository.ClientRepository;
import com.sda.ioana.petclinic.repository.ClientRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl() {
        this.clientRepository = new ClientRepositoryImpl();
    }

    @Override
    public List<Pet> findPetsForClientId(Long clientId) {
        Optional<Client> client = clientRepository.findPetsByClientId(clientId);
        if(client.isPresent()){
            return client.get().getPets();
        }
        return new ArrayList<>();

    }
}
