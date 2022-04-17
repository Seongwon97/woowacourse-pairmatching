package pairmatching.domain.crew;

import camp.nextstep.edu.missionutils.Randoms;

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
}
