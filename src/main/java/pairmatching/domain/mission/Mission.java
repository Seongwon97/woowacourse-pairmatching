package pairmatching.domain.mission;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Mission {

    RACING_CAR("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL("숫자야구게임", Level.LEVEL1),
    SHOPPING_BASKET("장바구니", Level.LEVEL2),
    PAY("결제", Level.LEVEL2),
    SUBWAY_MAP("지하철노선도", Level.LEVEL2),
    PERFORMANCE_IMPROVEMENT("성능개선", Level.LEVEL4),
    DEPLOYMENT("배포", Level.LEVEL4);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public boolean isSameLevel(Mission mission) {
        return this.level == mission.level;
    }

    public static Mission of(String name, Level level) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(name))
                .filter(value -> value.level == level)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
