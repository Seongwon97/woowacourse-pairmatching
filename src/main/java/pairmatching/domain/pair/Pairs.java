package pairmatching.domain.pair;

import pairmatching.Mission;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pairs {

    private final List<Pair> value;

    public Pairs() {
        this.value = new ArrayList<>();
    }

    public void addNewPairs(List<Pair> pairs) {
        value.addAll(pairs);
    }

    public boolean hasMatchingExperience(Pair pair) {
        return value.stream()
                .filter(pair::equals)
                .anyMatch(v -> pair.isSameLevel(v.getMission()));
    }

    public List<Pair> inquirePairsByMission(Mission mission) {
        return value.stream()
                .filter(v -> v.isSameMission(mission))
                .collect(Collectors.toList());
    }
}
