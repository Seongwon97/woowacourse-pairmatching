package pairmatching.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CrewServiceTest {

    @Test
    @DisplayName("크루들의 정보를 섞은 값을 반환한다.")
    void getShuffledCrewInfo() {
        CrewService service = new CrewService(List.of("Rex", "Skull", "Coffee"));

        assertThat(service.getShuffledCrew().size()).isEqualTo(3);
    }
}
