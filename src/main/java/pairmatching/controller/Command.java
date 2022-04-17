package pairmatching.controller;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Command {

    MATCHING("1"),
    INQUIRE("2"),
    RESET("3"),
    FINISH("Q");

    private final String order;

    Command(String order) {
        this.order = order;
    }

    public static Command of(String input) {
        return Arrays.stream(values())
                .filter(value -> value.order.equals(input))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
