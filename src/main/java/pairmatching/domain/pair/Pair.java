package pairmatching.domain.pair;

import pairmatching.Mission;
import pairmatching.domain.crew.Crew;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Pair {

    private final Mission mission;
    private final List<Crew> value;

    public Pair(Mission mission, List<Crew> value) {
        this.mission = mission;
        validateNumOfCrews(value);
        this.value = value;
    }

    private void validateNumOfCrews(List<Crew> value) {
        if (value.size() < 2 || value.size() > 3) {
            throw new IllegalArgumentException("[ERROR] 페어는 2명 또는 3명으로 구성됩니다.");
        }
    }

    public boolean isSameLevel(Mission mission) {
        return this.mission == mission;
    }

    public boolean isSameMission(Mission mission) {
        return this.mission == mission;
    }

    public Mission getMission() {
        return mission;
    }

    public List<Crew> getValue() {
        return List.copyOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;

        return equalDeterminant(pair);
    }

    private boolean equalDeterminant(Pair pair) {
        for (Crew crew : pair.value) {
            if (!value.contains(crew)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
