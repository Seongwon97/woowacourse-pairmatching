package pairmatching.domain.crew;

import pairmatching.domain.mission.Course;

import java.util.List;
import java.util.stream.Collectors;

public class Crews {

    private List<Crew> value;

    public Crews(List<Crew> value) {
        this.value = value;
    }

    public List<Crew> getValue() {
        return List.copyOf(value);
    }

    public List<Crew> getCrewsByCourse(Course course) {
        return value.stream()
                .filter(crew -> crew.isSameCourse(course))
                .collect(Collectors.toList());
    }
}
