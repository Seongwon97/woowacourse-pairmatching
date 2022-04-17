package pairmatching.domain.crew;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.domain.mission.Course;

import static org.assertj.core.api.Assertions.assertThat;

class CrewTest {

    @Test
    @DisplayName("크루 객체를 올바르게 생성한다.")
    void createCrew() {
        Crew crew = new Crew(Course.BACKEND, "Rex");
        assertThat(crew).isNotNull();
    }

    @Test
    @DisplayName("크루들의 이름이 같으면 같은 객체로 판단한다.")
    void equalsTest() {
        Crew crew1 = new Crew(Course.BACKEND, "Rex");
        Crew crew2 = new Crew(Course.BACKEND, "Rex");

        assertThat(crew1).isEqualTo(crew2);
    }

    @Test
    @DisplayName("크루들의 이름이 다르면 다른 객체로 판단한다.")
    void notEqualsTest() {
        Crew crew1 = new Crew(Course.BACKEND, "Rex");
        Crew crew2 = new Crew(Course.BACKEND, "Rex2");

        assertThat(crew1).isNotEqualTo(crew2);
    }
}
