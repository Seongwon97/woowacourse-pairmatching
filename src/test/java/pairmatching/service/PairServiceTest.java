package pairmatching.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.Mission;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.pair.Pair;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PairServiceTest {

    private Mission mission = Mission.RACING_CAR;

    @Test
    @DisplayName("크루가 짝수일 경우 모든 페어를 2명씩 매칭한다.")
    void createPairWithEvenPair() {
        PairService service = new PairService();
        List<Crew> crews = List.of(new Crew("Rex"), new Crew("Buzz"), new Crew("Woody"), new Crew("Pocky"));

        service.createNewPairs(mission, crews);
        List<Pair> savedPairs = service.inquirePairsByMission(mission);

        assertThat(savedPairs.get(savedPairs.size()-1).getValue().size())
                .isEqualTo(2);
    }

    @Test
    @DisplayName("크루가 홀수일 경우 마지막 페어는 3명이 한 팀이 된다.")
    void createPairWithOddPair() {
        PairService service = new PairService();
        List<Crew> crews = List.of(new Crew("Rex"), new Crew("Buzz"),
                new Crew("Woody"), new Crew("Pocky"), new Crew("Ham"));

        service.createNewPairs(mission, crews);
        List<Pair> savedPairs = service.inquirePairsByMission(mission);

        assertThat(savedPairs.get(savedPairs.size()-1).getValue().size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("과거 중복된 페어 매칭이 존재할 경우 예외가 발생한다.")
    void throwExceptionWithDuplicateMatching() {
        PairService service = new PairService();
        List<Crew> crews = List.of(new Crew("Rex"), new Crew("Buzz"),
                new Crew("Woody"), new Crew("Pocky"), new Crew("Ham"));

        service.createNewPairs(mission, crews);

        assertThatThrownBy(() -> service.createNewPairs(mission, crews))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 페어 매칭이 존재합니다.");
    }
}
