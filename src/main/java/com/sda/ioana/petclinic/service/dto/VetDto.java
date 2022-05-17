package com.sda.ioana.petclinic.service.dto;

//replica a modelului Vet deoarece controller-ul lucreaza cu service si cu DTO, nu direct cu modelul
public class VetDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String speciality;

    public VetDto(){}

    public VetDto(Long id, String firstName, String lastName, String address, String speciality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.speciality = speciality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
