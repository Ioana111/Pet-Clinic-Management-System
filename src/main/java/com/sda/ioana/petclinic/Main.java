package com.sda.ioana.petclinic;

import com.sda.ioana.petclinic.controller.ClientController;
import com.sda.ioana.petclinic.controller.ConsultController;
import com.sda.ioana.petclinic.controller.PetController;
import com.sda.ioana.petclinic.controller.VetController;
import com.sda.ioana.petclinic.option.UserOption;
import com.sda.ioana.petclinic.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionManager.getSessionFactory();

        VetController vetController = new VetController();
//        vetController.create();
        PetController petController = new PetController();
        ClientController clientController = new ClientController();
        ConsultController consultController = new ConsultController();

        UserOption option = UserOption.UNKNOWN;
        Scanner scanner = new Scanner(System.in);
        do {
            UserOption.printAllOptions();
            System.out.println("Choose an option.");
            String inputOption = scanner.nextLine();
            try {
                int userOption = Integer.parseInt(inputOption);
                option = UserOption.findByOptionNumber(userOption).orElse(UserOption.UNKNOWN);
            } catch (NumberFormatException e) {
                option = UserOption.UNKNOWN;
            }
            System.out.println(option.getPrettyName());

            switch (option){
                case ADD_NEW_VET:
                    vetController.create();
                    break;
                case SHOW_ALL:
                    vetController.showAllVets();
                    break;
                case DELETE_BY_ID:
                    vetController.deleteById();
                    break;
                case UPDATE_BY_ID:
                    vetController.updateById();
                    break;
                case ADD_NEW_PET:
                    petController.create();
                    break;
                case SHOW_ALL_VACCINATED_PETS:
                    petController.showAllVaccinated();
                    break;
                case SHOW_ALL_PETS_BY_CLINT_ID:
                    clientController.viewAllPetsForClient();
                    break;
                case SHOW_ALL_PETS:
                    petController.showAllPets();
                    break;
                case DELETE_PET_BY_ID:
                    petController.deleteById();
                    break;
                case UPDATE_PET_BY_ID:
                    petController.updateById();
                    break;
                case ADD_NEW_CONSULT:
                    consultController.create();
                    break;
                case UNKNOWN:
                    break;
                case EXIT:
                    System.out.println("bye");
                    break;
                default:
                    System.out.println("no impl option");
                    break;

            }

        } while (!option.equals(UserOption.EXIT));



        SessionManager.shutdown();

    }
}
