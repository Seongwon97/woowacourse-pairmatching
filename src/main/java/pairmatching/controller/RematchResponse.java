package pairmatching.controller;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum RematchResponse {

    YES("네"),
    NO("아니요");

    private final String order;

    RematchResponse(String order) {
        this.order = order;
    }

    public static RematchResponse of(String input) {
        return Arrays.stream(values())
                .filter(value -> value.order.equals(input))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
