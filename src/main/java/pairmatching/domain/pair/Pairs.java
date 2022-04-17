package pairmatching.domain.pair;

import pairmatching.Mission;
import pairmatching.domain.crew.Crew;

import java.util.ArrayList;
import java.util.List;

public class Pairs {

    private final Mission mission;
    private final List<Pair> pairs;

    public Pairs(Mission mission, List<Crew> crews) {
        this.mission = mission;
        List<Pair> pairs = new ArrayList<>();
        matchingPair(crews, pairs);
        this.pairs = pairs;
    }

    private void matchingPair(List<Crew> crews, List<Pair> pairs) {
        for (int i = 0; i < crews.size(); i = i + 2) {
            if ((crews.size() - i) == 3) {
                pairs.add(new Pair(crews.subList(i, i + 3)));
                break;
            }
            pairs.add(new Pair(crews.subList(i, i + 2)));
        }
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
