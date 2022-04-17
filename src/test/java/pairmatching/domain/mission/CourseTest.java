package pairmatching.domain.mission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CourseTest {

    @Test
    @DisplayName("문자열을 통해 올바른 인스턴스를 찾아낸다")
    void findCourseByString() {
        String input = "백엔드";
        Course course = Course.of(input);

        assertThat(course).isEqualTo(Course.BACKEND);
    }

    @Test
    @DisplayName("해당하는 문자열이 없으면 예외를 발생시킨다.")
    void throwExceptionWithInvalidInput() {
        String input = "잘못된 값";

        assertThatThrownBy(() -> Course.of(input))
                .isInstanceOf(NoSuchElementException.class);
    }

}
