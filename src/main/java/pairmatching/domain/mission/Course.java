package pairmatching.domain.mission;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course of(String name) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
