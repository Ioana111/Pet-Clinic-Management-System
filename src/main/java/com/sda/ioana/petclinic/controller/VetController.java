package com.sda.ioana.petclinic.controller;

import com.sda.ioana.petclinic.service.VetService;
import com.sda.ioana.petclinic.service.VetServiceImpl;
import com.sda.ioana.petclinic.service.dto.VetDto;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

import java.util.List;
import java.util.Scanner;

public class VetController {

    private final VetService vetService;
    private Scanner scanner;

    public VetController() {
        this.vetService = new VetServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void create() {
        try {
            System.out.println("Please insert first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Please insert last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Please insert address: ");
            String address = scanner.nextLine();
            System.out.println("Please insert speciality: ");
            String speciality = scanner.nextLine();

            vetService.create(firstName, lastName, address, speciality);
            System.out.println("Vet " + firstName + " " + lastName + " was successfully created.");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("Vet was not created; Internal server error");
        }

    }

    public void showAllVets() {
        List<VetDto> vets = vetService.findAll();
        if (vets.isEmpty()) {
            System.out.println("No vets");
            return;
        }
        vets.stream()
                .forEach(vetDto ->
                        System.out.println("\n ID: " + vetDto.getId()
                                + "\n Name: " + vetDto.getFirstName() + " " + vetDto.getLastName()
                                + "\n Address: " + vetDto.getAddress()
                                + "\n Speciality: " + vetDto.getSpeciality())
                );
    }

    public void deleteById(){
        try {
            System.out.println("Please insert the vet id: ");
            String idString = scanner.nextLine();
            Long id = Long.parseLong(idString);
            vetService.deleteById(id);
            System.out.println("Vet was successfully deleted!");
        } catch (NumberFormatException e){
            System.out.println("Invalid parameter");
        }
    }

    public void updateById(){
        try {
            System.out.println("Please insert id:");
            String idString = scanner.nextLine();
            long id = Long.parseLong(idString);
            System.out.println("Please insert first name:");
            String firstName = scanner.nextLine();
            System.out.println("Please insert last name:");
            String lastName = scanner.nextLine();
            System.out.println("Please insert the address:");
            String address = scanner.nextLine();
            System.out.println("Please insert the speciality:");
            String speciality = scanner.nextLine();


            vetService.updateById(id, firstName, lastName, address, speciality);
            System.out.println("The veterinarian " + firstName + " was updated.");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid parameter.");
        } catch (Exception ex) {
            System.out.println("The veterinarian was not updated, internal server error.");
        }
    }

}
