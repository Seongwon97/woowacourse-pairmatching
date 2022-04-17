package pairmatching.domain.crew;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pairmatching.CrewInfo.*;

class CrewsTest {

    @Test
    @DisplayName("크루들의 이름을 받아 올바른 인스턴스를 생성한다.")
    void createCrews() {
        Crews crews = new Crews(List.of(Rex, Ham, Buzz));

        assertThat(crews).isNotNull();
    }
}
