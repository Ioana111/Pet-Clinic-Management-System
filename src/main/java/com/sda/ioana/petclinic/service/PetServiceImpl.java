package com.sda.ioana.petclinic.service;

import com.sda.ioana.petclinic.model.Client;
import com.sda.ioana.petclinic.model.Pet;
import com.sda.ioana.petclinic.repository.ClientRepository;
import com.sda.ioana.petclinic.repository.ClientRepositoryImpl;
import com.sda.ioana.petclinic.repository.PetRepository;
import com.sda.ioana.petclinic.repository.PetRepositoryImpl;
import com.sda.ioana.petclinic.service.dto.PetDto;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PetServiceImpl implements PetService{

    private final PetRepository petRepository;
    private final ClientRepository clientRepository;

    //le facem final ca sa nu poata fi reinstantiate pe parcurs;

    public PetServiceImpl() {
        this.petRepository = new PetRepositoryImpl();
        this.clientRepository = new ClientRepositoryImpl();
    }

    @Override
    public void create(String race, Date dateOfBirth, boolean isVaccinated, String ownerFirstName, String ownerLastName) throws InvalidParameterException {
        if (race == null || race.isBlank()) {
            throw new InvalidParameterException("Race is null or empty.");
        }
        if (ownerFirstName == null || ownerFirstName.isBlank()) {
            throw new InvalidParameterException("Owner first name is null or empty.");
        }
        if (ownerLastName == null || ownerLastName.isBlank()) {
            throw new InvalidParameterException("Owner last name is null or empty.");
        }
        if (dateOfBirth == null) {
            throw new InvalidParameterException("Date of birth is null.");
        }
        if (dateOfBirth.after(new Date())) {
            throw new InvalidParameterException("Date of birth is in the future.");
        }
        Optional<Client> clientFromDB = clientRepository.findByName(ownerFirstName, ownerLastName);

        if(clientFromDB.isEmpty()){
            Client client = new Client(ownerFirstName, ownerLastName, null, null);
            clientRepository.create(client);
            clientFromDB = Optional.of(client);
        }
        Pet pet = new Pet(race, dateOfBirth, isVaccinated);
        pet.setOwner(clientFromDB.get());
        petRepository.create(pet);

    }

    @Override
    public List<Pet> findAllVaccinated() {
        return  petRepository.findAllVaccinated();
    }

    @Override
    public List<PetDto> showAll() {
        return petRepository.findAll()
                .stream()
                .map(pet ->
                        new PetDto(
                                pet.getId(),
                                pet.getRace(),
                                pet.getDateOfBirth(),
                                pet.getVaccinated(),
                                pet.getOwner())    )
                .collect(Collectors.toList());
    }


}
