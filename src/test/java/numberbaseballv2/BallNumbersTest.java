package numberbaseballv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallNumbersTest {


    @Test
    void 한개와_세개_비교_스트라이크() {
        BallNumbers 세개 = new BallNumbers(List.of(
                new BallNumber(1, 1),
                new BallNumber(2, 2),
                new BallNumber(3, 3)
        ));
        BallNumber 한개 = new BallNumber(1, 1);

        MatchResult 결과 = 세개.match(한개);

        assertThat(결과).isEqualTo(MatchResult.STRIKE);
    }

    @Test
    void 한개와_세개_비교_볼() {
        BallNumbers 세개 = new BallNumbers(List.of(
                new BallNumber(1, 1),
                new BallNumber(2, 2),
                new BallNumber(3, 3)
        ));
        BallNumber 한개 = new BallNumber(3, 1);

        MatchResult 결과 = 세개.match(한개);

        assertThat(결과).isEqualTo(MatchResult.BALL);
    }

    @Test
    void 한개와_세개_비교_나띵() {
        BallNumbers 세개 = new BallNumbers(List.of(
                new BallNumber(1, 1),
                new BallNumber(2, 2),
                new BallNumber(3, 3)
        ));
        BallNumber 한개 = new BallNumber(1, 9);

        MatchResult 결과 = 세개.match(한개);

        assertThat(결과).isEqualTo(MatchResult.NOTHING);
    }
}
