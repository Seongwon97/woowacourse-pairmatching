package pairmatching.domain.mission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LevelTest {

    @Test
    @DisplayName("문자열을 통해 올바른 인스턴스를 찾아낸다")
    void findLevelByString() {
        String input = "레벨1";
        Level level = Level.of(input);

        assertThat(level).isEqualTo(Level.LEVEL1);
    }

    @Test
    @DisplayName("해당하는 문자열이 없으면 예외를 발생시킨다.")
    void throwExceptionWithInvalidInput() {
        String input = "잘못된 값";

        assertThatThrownBy(() -> Level.of(input))
                .isInstanceOf(NoSuchElementException.class);
    }
}
