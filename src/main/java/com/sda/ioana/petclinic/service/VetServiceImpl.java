package com.sda.ioana.petclinic.service;

import com.sda.ioana.petclinic.model.Vet;
import com.sda.ioana.petclinic.repository.VetRepository;
import com.sda.ioana.petclinic.repository.VetRepositoryImpl;
import com.sda.ioana.petclinic.service.dto.VetDto;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;
import org.hibernate.dialect.lock.OptimisticEntityLockException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;

    public VetServiceImpl() {
        this.vetRepository = new VetRepositoryImpl();
    }

    @Override
    public void create(
            String firstName,
            String lastName,
            String address,
            String speciality) throws InvalidParameterException {
        //ca sa fie si mai smart vom face validare pe datele primite
        if (firstName == null || firstName.isBlank()) {
            throw new InvalidParameterException("First name is null or empty.");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new InvalidParameterException("Last name is null or empty.");
        }
        if (address == null || address.isBlank()) {
            throw new InvalidParameterException("Address is null or empty.");
        }
        if (speciality == null || speciality.isBlank()) {
            throw new InvalidParameterException("Speciality is null or empty.");
        }
        vetRepository.create(new Vet(firstName, lastName, address, speciality));

    }

    @Override
    public List<VetDto> findAll() {
        return vetRepository.findAll()
                .stream()
                .map(vet ->
                        new VetDto(
                                vet.getId(),
                                vet.getFirstName(),
                                vet.getLastName(),
                                vet.getAddress(),
                                vet.getSpeciality()
                        )
                ).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, String firstName, String lastName, String address, String speciality) throws InvalidParameterException {
        if (firstName == null || firstName.isBlank()) {
            throw new InvalidParameterException("First name is null or empty.");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new InvalidParameterException("Last name is null or empty.");
        }
        if (address == null || address.isBlank()) {
            throw new InvalidParameterException("Address is null or empty.");
        }
        if (speciality == null || speciality.isBlank()) {
            throw new InvalidParameterException("Speciality is null or empty.");
        }
        Optional<Vet> vet = vetRepository.findById(id);

        if (vet.isPresent()) {
            vet.get().setFirstName(firstName);
            vet.get().setLastName(lastName);
            vet.get().setAddress(address);
            vet.get().setSpeciality(speciality);

            vetRepository.update(vet.get());
        }
    }

    @Override
    public List<Vet> findByMultipleParameters(String firstName, String lastName, String address, String speciality) throws InvalidParameterException {
        return vetRepository.findByMultipleParameters(firstName, lastName, address, speciality);
    }


}
