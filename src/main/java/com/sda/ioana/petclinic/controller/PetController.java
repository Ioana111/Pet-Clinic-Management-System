package com.sda.ioana.petclinic.controller;

import com.sda.ioana.petclinic.service.PetService;
import com.sda.ioana.petclinic.service.PetServiceImpl;
import com.sda.ioana.petclinic.service.dto.PetDto;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PetController {

    private final PetService petService;
    private final Scanner scanner;
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(DATE_FORMAT);
    private final Scanner sc;


    public PetController() {
        this.scanner = new Scanner(System.in);
        this.sc = new Scanner(System.in);
        this.petService = new PetServiceImpl();
    }

    public void create() {
        try {
            System.out.println("Please insert dog race: ");
            String race = scanner.nextLine();

            System.out.println("Please insert date of birth: ");
            String dateOfBirth = scanner.nextLine();
            Date birthDate = FORMATTER.parse(dateOfBirth);

            System.out.println("Please insert true if dog is vaccinated or false otherwise ");
            boolean isVaccinated = sc.nextBoolean();

            System.out.println("Please insert owner's first name: ");
            String ownerFirstName = scanner.nextLine();

            System.out.println("Please insert owner's last name: ");
            String ownerLastName = scanner.nextLine();

            petService.create(race, birthDate, isVaccinated, ownerFirstName, ownerLastName);
            System.out.println("Pet " + race + " was successfully created.");

        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (ParseException parseException) {
            System.out.println("Please insert a correct date of birth. Format: DD-MM-YYYY");
        } catch (InputMismatchException mismatchException) {
            System.out.println("Please insert true or false for the vaccinated status .");
        } catch (Exception ex) {
            System.out.println("Pet was not created; Internal server error");
        }

    }

    public void showAllVaccinated() {
        petService.findAllVaccinated()
                .stream()
                .forEach(pet -> System.out.println("Race: " + pet.getRace() + " Date of birth: " + FORMATTER.format(pet.getDateOfBirth()) + " Is vaccinated : " + (pet.getVaccinated() ? "YES" : "NO")));
    }


    public void showAllPets() {
        List<PetDto> pets = petService.showAll();
        if (pets.isEmpty()) {
            System.out.println("No pet");
            return;
        }
        pets.stream()
                .forEach(petDto ->
                        System.out.println("\n ID: " + petDto.getId()
                                + "\n Race: " + petDto.getRace()
                                + "\n Date Of birth: " + petDto.getDateOfBirth()
                                + "\n is vaccinated: " + petDto.getVaccinated()
                                + "\n Owner: " + petDto.getOwner().getFirstName() + " " + petDto.getOwner().getLastName())
                );
    }

    public void deleteById(){
        try {
            System.out.println("Please insert the pet id: ");
            String idString = scanner.nextLine();
            Long id = Long.parseLong(idString);
            petService.deletePetById(id);
            System.out.println("Pet was successfully deleted!");
        } catch (NumberFormatException e){
            System.out.println("Invalid parameter");
        }
    }
}


