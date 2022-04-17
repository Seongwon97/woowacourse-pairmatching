package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {

    private List<Crew> value;

    public Crews(List<String> value) {
        this.value = value.stream()
                .map(Crew::new)
                .collect(Collectors.toList());

    }
}
