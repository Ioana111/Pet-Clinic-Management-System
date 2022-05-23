package com.sda.ioana.petclinic.controller;

import com.sda.ioana.petclinic.service.ClientService;
import com.sda.ioana.petclinic.service.ClientServiceImpl;
import com.sda.ioana.petclinic.service.exception.InvalidParameterException;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientController {
    private final ClientService clientService;
    private final Scanner scanner;

    public ClientController() {
        this.clientService = new ClientServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void viewAllPetsForClient() {
        try {
            System.out.println("Please insert client id");
            Long inputClientID = Long.parseLong(scanner.nextLine());
            clientService.findPetsForClientId(inputClientID).stream().forEach(pet -> System.out.println(pet));


        } catch (NumberFormatException e) {
            System.out.println("Please insert a valid client id.");
        } catch (Exception e) {
            System.out.println("Internal server error.");
            e.printStackTrace();
        }
    }


}
