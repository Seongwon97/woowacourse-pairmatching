package pairmatching.domain.pair;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.pair.Pair;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PairTest {

    @Test
    @DisplayName("2명의 크루 정보를 받아 Pair를 생성한다.")
    void createPairWithTwoCrew() {
        Pair pair = new Pair(List.of(new Crew("Rex"), new Crew("Buzz")));

        assertThat(pair).isNotNull();
    }

    @Test
    @DisplayName("3명의 크루 정보를 받아 Pair를 생성한다.")
    void createPairWithThreeCrew() {
        Pair pair = new Pair(List.of(new Crew("Rex"), new Crew("Buzz"), new Crew("Woody")));

        assertThat(pair).isNotNull();
    }

    @Test
    @DisplayName("4명 이상의 크루는 페어가 될 수 없다.")
    void throwExceptionWithPairWithOverThreeCrews() {
        List<Crew> crews = List.of(new Crew("Rex"), new Crew("Buzz"), new Crew("Woody"), new Crew("Pocky"));

        assertThatThrownBy(() -> new Pair(crews))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 페어는 2명 또는 3명으로 구성됩니다.");
    }

    @Test
    @DisplayName("2명 미만의 크루는 페어가 될 수 없다.")
    void throwExceptionWithPairWithUnderTwoCrews() {
        List<Crew> crews = List.of(new Crew("Rex"));

        assertThatThrownBy(() -> new Pair(crews))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 페어는 2명 또는 3명으로 구성됩니다.");
    }

    @Test
    @DisplayName("매칭된 크루들이 같으면 같은 객체로 판단한다.")
    void equalsTest() {
        Pair pair1 = new Pair(List.of(new Crew("Rex"), new Crew("Buzz")));
        Pair pair2 = new Pair(List.of(new Crew("Rex"), new Crew("Buzz")));

        assertThat(pair1).isEqualTo(pair2);
    }

    @Test
    @DisplayName("매칭된 크루들이 다르면 다른 객체로 판단한다.")
    void notEqualsTest() {
        Pair pair1 = new Pair(List.of(new Crew("Rex"), new Crew("Buzz")));
        Pair pair2 = new Pair(List.of(new Crew("Rex1"), new Crew("Buzz")));

        assertThat(pair1).isNotEqualTo(pair2);
    }
}
