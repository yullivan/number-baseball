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

    @Test
    void 비교_스트라이크() {
        BallNumber ballNumber1 = new BallNumber(1, 1);
        BallNumber ballNumber2 = new BallNumber(1, 1);

        MatchResult 결과 = ballNumber1.match(ballNumber2);

        assertThat(결과).isEqualTo(MatchResult.STRIKE);
    }

    @Test
    void 비교_볼() {
        BallNumber ballNumber1 = new BallNumber(1, 1);
        BallNumber ballNumber2 = new BallNumber(2, 1);

        MatchResult 결과 = ballNumber1.match(ballNumber2);

        assertThat(결과).isEqualTo(MatchResult.BALL);
    }

    @Test
    void 비교_나띵() {
        BallNumber ballNumber1 = new BallNumber(1, 1);
        BallNumber ballNumber2 = new BallNumber(1, 2);

        MatchResult 결과 = ballNumber1.match(ballNumber2);

        assertThat(결과).isEqualTo(MatchResult.NOTHING);
    }
}
