package pairmatching.domain.pair;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.Mission;
import pairmatching.domain.crew.Crew;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PairsTest {

    private Mission mission = Mission.RACING_CAR;
    private Pair pair1 = new Pair(mission, List.of(new Crew("Rex"), new Crew("Buzz")));
    private Pair pair2 = new Pair(mission, List.of(new Crew("Woody"), new Crew("Pocky")));

    @Test
    @DisplayName("패어 매칭 정보를 갖는 인스턴스를 만든다.")
    void createPairs() {
        Pairs pairs = new Pairs();
        assertThat(pairs).isNotNull();
    }

    @Test
    @DisplayName("같은 레벨에서 페어 매칭을 한 경험이 있으면 true를 반환한다.")
    void hasMatchingExperience() {
        List<Pair> newPairs = List.of(pair1, pair2);

        Pairs pairs = new Pairs();
        pairs.addNewPairs(newPairs);

        assertThat(pairs.hasMatchingExperience(pair1)).isTrue();
    }

    @Test
    @DisplayName("같은 레벨에서 페어 매칭을 한 경험이 없으면 false를 반환한다.")
    void hasNotMatchingExperience() {
        List<Pair> newPairs = List.of(pair2);

        Pairs pairs = new Pairs();
        pairs.addNewPairs(newPairs);

        assertThat(pairs.hasMatchingExperience(pair1)).isFalse();
    }
}
