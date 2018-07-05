package racingcar.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    public void getMoveMarker() {
        assertThat(ResultView.getMoveMarker(5))
                .isEqualTo("-----");
    }
}