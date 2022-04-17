package pairmatching.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RematchResponseTest {

    @Test
    @DisplayName("문자열을 통해 올바른 인스턴스를 찾아낸다")
    void findRematchResponseByString() {
        String input = "네";
        RematchResponse response = RematchResponse.of(input);

        assertThat(response).isEqualTo(RematchResponse.YES);
    }

    @Test
    @DisplayName("해당하는 문자열이 없으면 예외를 발생시킨다.")
    void throwExceptionWithInvalidInput() {
        String input = "잘못된 값";

        assertThatThrownBy(() -> RematchResponse.of(input))
                .isInstanceOf(NoSuchElementException.class);
    }
}
