package pairmatching.service;

import pairmatching.domain.mission.Course;
import pairmatching.domain.mission.Mission;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.pair.Pair;
import pairmatching.domain.pair.Pairs;
import pairmatching.service.exception.DuplicatePairException;

import java.util.ArrayList;
import java.util.List;

public class PairService {

    private final Pairs pairs;

    public PairService() {
        this.pairs = new Pairs();
    }

    public void createNewPairs(Mission mission, List<Crew> crews) {
        List<Pair> newPairs = matchNewPairs(mission, crews);
        for (Pair pair : newPairs) {
            if (pairs.hasMatchingExperience(pair)) {
                throw new DuplicatePairException();
            }
        }
        pairs.addNewPairs(newPairs);
    }

    private List<Pair> matchNewPairs(Mission mission, List<Crew> crews) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < crews.size(); i = i + 2) {
            if ((crews.size() - i) == 3) {
                pairs.add(new Pair(mission, crews.subList(i, i + 3)));
                break;
            }
            pairs.add(new Pair(mission, crews.subList(i, i + 2)));
        }
        return pairs;
    }

    public List<Pair> inquirePairs(Mission mission, Course course) {
        return pairs.inquirePairs(mission, course);
    }

    public void deletePairs(Mission mission, Course course) {
        pairs.deletePairs(mission, course);
    }
}
