package pairmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrewTest {

    @Test
    @DisplayName("크루 객체를 올바르게 생성한다.")
    void createCrew() {
        Crew crew = new Crew("Rex");
        assertThat(crew).isNotNull();
    }
}
