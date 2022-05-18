package com.sda.ioana.petclinic.option;

import java.util.Arrays;
import java.util.Optional;

public enum UserOption {
    ADD_NEW_VET("Add new vet", 1),
    SHOW_ALL("Display all vets", 2),
    DELETE_BY_ID("Delete vet by id", 3),
    UPDATE_BY_ID("Update vet by id", 4),
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
