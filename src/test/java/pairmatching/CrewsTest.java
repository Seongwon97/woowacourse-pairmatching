package pairmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CrewsTest {

    @Test
    @DisplayName("크루들의 이름을 받아 올바른 인스턴스를 생성한다.")
    void createCrews() {
        Crews crews = new Crews(List.of("Rex", "Skull", "Coffee"));

        assertThat(crews).isNotNull();
    }

    @Test
    @DisplayName("크루들의 정보를 섞은 값을 반환한다.")
    void getShuffledCrewInfo() {
        Crews crews = new Crews(List.of("Rex", "Skull", "Coffee"));

        assertThat(crews.shuffleCrew().size()).isEqualTo(3);
    }
}
