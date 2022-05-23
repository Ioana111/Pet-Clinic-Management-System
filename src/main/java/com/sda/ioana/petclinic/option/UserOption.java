package com.sda.ioana.petclinic.option;

import java.util.Arrays;
import java.util.Optional;

public enum UserOption {
    ADD_NEW_VET("Add new vet", 1),
    SHOW_ALL("Display all vets", 2),
    DELETE_BY_ID("Delete vet by id", 3),
    UPDATE_BY_ID("Update vet by id", 4),
    ADD_NEW_PET("Add new pet", 5),
    SHOW_ALL_VACCINATED_PETS("Show all vaccinated pets", 6),
    SHOW_ALL_PETS_BY_CLINT_ID("Show all pets using client id", 7),
    SHOW_ALL_PETS("Display all pets", 8),
    DELETE_PET_BY_ID("Delete pet by id", 9),
    UPDATE_PET_BY_ID("Update pet by id", 10),
    ADD_NEW_CONSULT("Add new consult", 11),
    SHOW_ALL_CONSULTS_WITH_UNVACCINATED_PETS("Show all consults with unvaccinated pets", 12),
    SHOW_ALL_CONSUTS_FOR_SPECIFIC_VET_AND_BETWEEN_INTERVAL("Show all consults for specific vet and between interval", 13),
    EXIT("Exit", 999),
    UNKNOWN("Unknown option. Try again!", 1000);

    private final String prettyName;

    private final int optionNumber;


    UserOption(String prettyName, int optionNumber) {
        this.prettyName = prettyName;
        this.optionNumber = optionNumber;
    }

    public String getPrettyName() {
        return prettyName;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public static void printAllOptions() {
        Arrays.stream(UserOption.values())
                .filter(userOption -> !userOption.equals(UserOption.UNKNOWN)).forEach(option -> System.out.println(option.getPrettyName() + " -> " + option.getOptionNumber()));
    }

    public static Optional<UserOption> findByOptionNumber(int optionNumber) {
        return Arrays.stream(UserOption.values())
                .filter(userOption -> userOption.getOptionNumber() == optionNumber)
                .findAny();
    }


}
