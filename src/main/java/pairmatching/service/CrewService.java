package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.mission.Course;
import pairmatching.domain.pair.Pairs;

import java.util.List;

public class CrewService {

    private final Crews crews;

    public CrewService(List<Crew> crewNames) {
        this.crews = new Crews(crewNames);
    }

    public List<Crew> getShuffledCrew(Course course) {
        return List.copyOf(Randoms.shuffle(crews.getCrewsByCourse(course)));
    }
}
