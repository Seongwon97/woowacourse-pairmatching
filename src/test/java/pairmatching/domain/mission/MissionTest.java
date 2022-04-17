package pairmatching.domain.mission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MissionTest {

    @Test
    @DisplayName("같은 레벨일 경우 true를 반환한다.")
    void isSameLevel() {

        assertThat(Mission.RACING_CAR.isSameLevel(Mission.LOTTO))
                .isTrue();
    }

    @Test
    @DisplayName("다른 레벨일 경우 false를 반환한다.")
    void isNotSameLevel() {

        assertThat(Mission.RACING_CAR.isSameLevel(Mission.DEPLOYMENT))
                .isFalse();
    }
}
