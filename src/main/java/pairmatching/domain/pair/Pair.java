package pairmatching.domain.pair;

import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.crew.Crew;

import java.util.List;
import java.util.Objects;

public class Pair {

    private final Mission mission;
    private final List<Crew> crews;

    public Pair(Mission mission, List<Crew> value) {
        this.mission = mission;
        validateNumOfCrews(value);
        this.crews = value;
    }

    private void validateNumOfCrews(List<Crew> value) {
        if (value.size() < 2 || value.size() > 3) {
            throw new IllegalArgumentException("[ERROR] 페어는 2명 또는 3명으로 구성됩니다.");
        }
    }

    public boolean isSameLevel(Mission mission) {
        return this.mission.isSameLevel(mission);
    }

    public boolean isSameMission(Mission mission) {
        return this.mission == mission;
    }

    public boolean isSameCourse(Course course) {
        return crews.get(0).isSameCourse(course);
    }

    public Mission getMission() {
        return mission;
    }

    public List<Crew> getCrews() {
        return List.copyOf(crews);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;

        return equalDeterminant(pair);
    }

    private boolean equalDeterminant(Pair pair) {
        for (Crew crew : pair.crews) {
            if (!crews.contains(crew)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(crews);
    }
}
