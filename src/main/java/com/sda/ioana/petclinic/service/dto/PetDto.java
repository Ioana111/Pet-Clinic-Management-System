package com.sda.ioana.petclinic.service.dto;

import com.sda.ioana.petclinic.model.Client;

import java.util.Date;

public class PetDto {
    private Long id;
    private String race;
    private Date dateOfBirth;
    private Boolean isVaccinated;
    private Client owner;

    public PetDto(Long id, String race, Date dateOfBirth, Boolean isVaccinated, Client owner) {
        this.id = id;
        this.race = race;
        this.dateOfBirth = dateOfBirth;
        this.isVaccinated = isVaccinated;
        this.owner = new Client(owner.getFirstName(), owner.getLastName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

}
