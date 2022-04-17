package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.pair.Pairs;

import java.util.List;

public class CrewService {

    private final Crews crews;

    public CrewService(List<String> crewNames) {
        this.crews = new Crews(crewNames);
    }

    public List<Crew> getShuffledCrew() {
        return List.copyOf(Randoms.shuffle(crews.getValue()));
    }
}
