package pairmatching.domain.crew;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Crews {

    private List<Crew> value;

    public Crews(List<String> value) {
        this.value = value.stream()
                .map(Crew::new)
                .collect(Collectors.toList());
    }

    public List<Crew> getValue() {
        return List.copyOf(value);
    }
}
