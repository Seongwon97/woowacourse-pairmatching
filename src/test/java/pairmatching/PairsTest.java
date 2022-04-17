package pairmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PairsTest {

    @Test
    @DisplayName("크루들의 정보 및 미션 정보를 받아 페어 매칭을 만든다.")
    void createPairsEachLevel() {
        Pairs pairs = new Pairs(Mission.RACING_CAR,
                List.of(new Crew("Rex"), new Crew("Buzz"), new Crew("Woody"), new Crew("Pocky")));

        assertThat(pairs).isNotNull();
    }

    @Test
    @DisplayName("크루가 짝수일 경우 모든 페어를 2명씩 매칭한다.")
    void createPairWithEvenPair() {
        Pairs pairs = new Pairs(Mission.RACING_CAR,
                List.of(new Crew("Rex"), new Crew("Buzz"), new Crew("Woody"), new Crew("Pocky")));

        assertThat(pairs.getPairs()
                .get(pairs.getPairs().size() -1)
                .getValue().size())
                .isEqualTo(2);
    }

    @Test
    @DisplayName("크루가 홀수일 경우 마지막 페어는 3명이 한 팀이 된다.")
    void createPairWithOddPair() {
        Pairs pairs = new Pairs(Mission.RACING_CAR,
                List.of(new Crew("Rex"), new Crew("Buzz"), new Crew("Woody"), new Crew("Pocky"), new Crew("Ham")));

        assertThat(pairs.getPairs()
                .get(pairs.getPairs().size() -1)
                .getValue().size())
                .isEqualTo(3);
    }
}
