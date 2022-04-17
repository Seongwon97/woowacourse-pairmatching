package pairmatching;

import java.util.List;

public class Pair {

    private final List<Crew> value;

    public Pair(List<Crew> value) {
        validateNumOfCrews(value);
        this.value = value;
    }

    private void validateNumOfCrews(List<Crew> value) {
        if (value.size() < 2 || value.size() > 3) {
            throw new IllegalArgumentException("[ERROR] 페어는 2명 또는 3명으로 구성됩니다.");
        }
    }

    public List<Crew> getValue() {
        return value;
    }
}
