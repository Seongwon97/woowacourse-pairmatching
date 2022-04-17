package pairmatching.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrewInfoReaderTest {

    @Test
    @DisplayName("파일로부터 크루들의 정보를 올바르게 가져온다")
    void readCrewsInfo() {
        assertThat(CrewInfoReader.readCrewsInfo().size())
                .isEqualTo(35);
    }

}
