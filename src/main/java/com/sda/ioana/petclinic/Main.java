package com.sda.ioana.petclinic;

import com.sda.ioana.petclinic.controller.VetController;
import com.sda.ioana.petclinic.option.UserOption;
import com.sda.ioana.petclinic.utils.SessionManager;
import org.hibernate.Session;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionManager.getSessionFactory();

        VetController vetController = new VetController();
//        vetController.create();


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
