package numberbaseballv2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @Test
    void 생성() {
        BallNumber ballNumber = new BallNumber(1, 3);
        assertThat(ballNumber.getPosition()).isEqualTo(1);
        assertThat(ballNumber.getValue()).isEqualTo(3);
    }

    @Test
    void 생성불가() {
        assertThatThrownBy(() -> new BallNumber(7, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
