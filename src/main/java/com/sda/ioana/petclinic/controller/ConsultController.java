package com.sda.ioana.petclinic.controller;

import com.sda.ioana.petclinic.service.ConsultService;
import com.sda.ioana.petclinic.service.ConsultServiceImpl;
import com.sda.ioana.petclinic.service.PetService;
import com.sda.ioana.petclinic.service.VetService;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsultController {

    private final ConsultService consultService;
    private final Scanner scanner;
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(DATE_FORMAT);
    private final Scanner sc;

    public ConsultController() {
        this.consultService = new ConsultServiceImpl();
        this.scanner = new Scanner(System.in);
        this.sc = new Scanner(System.in);
    }

    public void create() {
        try {
            System.out.println("Please insert date for the consult: ");
            String date = scanner.nextLine();
            Date date1 = FORMATTER.parse(date);

            System.out.println("Please insert consult description: ");
            String description = scanner.nextLine();

            System.out.println("Please insert vet id");
            String vetId = scanner.nextLine();
            Long vetId1 = Long.parseLong(vetId);

            System.out.println("Please insert pet id");
            String petId = scanner.nextLine();
            Long petId1 = Long.parseLong(petId);

            consultService.create(date1, description, vetId1, petId1);

        } catch (ParseException parseException) {
            System.out.println("Please insert a correct date of birth. Format: DD-MM-YYYY");
        } catch (InvalidParameterException e){
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("Pet was not created; Internal server error");
        }


    }

}
