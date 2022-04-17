package pairmatching.domain.mission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("문자열과 레벨 값을 통해 올바른 인스턴스를 찾아낸다")
    void findMissionByString() {
        String input = "자동차경주";
        Level level = Level.LEVEL1;
        Mission mission = Mission.of(input, level);

        assertThat(mission).isEqualTo(Mission.RACING_CAR);
    }

    @Test
    @DisplayName("해당하는 문자열이 없으면 예외를 발생시킨다.")
    void throwExceptionWithInvalidInput() {
        String input = "잘못된 값";
        Level level = Level.LEVEL1;

        assertThatThrownBy(() -> Mission.of(input, level))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("해당하는 미션이 해당 레벨에 없으면 예외를 발생시킨다.")
    void throwExceptionWithInvalidLevel() {
        String input = "잘못된 값";
        Level level = Level.LEVEL2;

        assertThatThrownBy(() -> Mission.of(input, level))
                .isInstanceOf(NoSuchElementException.class);
    }
}
