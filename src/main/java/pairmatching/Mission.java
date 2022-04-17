package pairmatching;

import pairmatching.domain.Level;

public enum Mission {

    RACING_CAR(Level.LEVEL1),
    LOTTO(Level.LEVEL1),
    BASEBALL(Level.LEVEL1),
    SHOPPING_BASKET(Level.LEVEL2),
    PAY(Level.LEVEL2),
    SUBWAY_MAP(Level.LEVEL2),
    PERFORMANCE_IMPROVEMENT(Level.LEVEL4),
    DEPLOYMENT(Level.LEVEL4);

    private final Level level;

    Mission(Level level) {
        this.level = level;
    }

    public boolean isSameLevel(Mission mission) {
        return this.level == mission.level;
    }
}
