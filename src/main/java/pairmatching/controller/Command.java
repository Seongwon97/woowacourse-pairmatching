package pairmatching.controller;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Command {

    MATCHING("1", PairMatchingController::matching),
    INQUIRE("2", PairMatchingController::inquire);

    private final String order;
    private final Runnable runnable;

    Command(String order, Runnable runnable) {
        this.order = order;
        this.runnable = runnable;
    }

    public static Command of(String input) {
        return Arrays.stream(values())
                .filter(value -> value.order.equals(input))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public void execute() {
        this.runnable.run();
    }
}
