package numberbaseballv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Test
    void 세개와_세개_비교_3스트라이크() {
        BallNumbers ballNumbers1 = new BallNumbers(List.of(
                new BallNumber(1, 1),
                new BallNumber(2, 2),
                new BallNumber(3, 3)
        ));
        BallNumbers ballNumbers2 = new BallNumbers(List.of(
                new BallNumber(1, 1),
                new BallNumber(2, 2),
                new BallNumber(3, 3)
        ));

        GameResult 결과 = ballNumbers1.match(ballNumbers2);

        assertThat(결과.getStrikeCount()).isEqualTo(3);
        assertThat(결과.getBallCount()).isEqualTo(0);
    }

    @Test
    void 세개와_세개_비교_1스트라이크_2볼() {
        BallNumbers ballNumbers1 = new BallNumbers(List.of(
                new BallNumber(1, 1),
                new BallNumber(2, 2),
                new BallNumber(3, 3)
        ));
        BallNumbers ballNumbers2 = new BallNumbers(List.of(
                new BallNumber(3, 1),
                new BallNumber(2, 2),
                new BallNumber(1, 3)
        ));

        GameResult 결과 = ballNumbers1.match(ballNumbers2);

        assertThat(결과.getStrikeCount()).isEqualTo(1);
        assertThat(결과.getBallCount()).isEqualTo(2);

    }

    @Test
    void 세개와_세개_비교_3볼() {
        BallNumbers ballNumbers1 = new BallNumbers(List.of(
                new BallNumber(1, 1),
                new BallNumber(2, 2),
                new BallNumber(3, 3)
        ));
        BallNumbers ballNumbers2 = new BallNumbers(List.of(
                new BallNumber(1, 2),
                new BallNumber(2, 3),
                new BallNumber(3, 1)
        ));

        GameResult 결과 = ballNumbers1.match(ballNumbers2);

        assertThat(결과.getStrikeCount()).isEqualTo(0);
        assertThat(결과.getBallCount()).isEqualTo(3);
    }

    @Test
    void 세개와_세개_비교_아웃() {
        BallNumbers ballNumbers1 = new BallNumbers(List.of(
                new BallNumber(1, 1),
                new BallNumber(2, 2),
                new BallNumber(3, 3)
        ));
        BallNumbers ballNumbers2 = new BallNumbers(List.of(
                new BallNumber(1, 6),
                new BallNumber(2, 7),
                new BallNumber(3, 8)
        ));

        GameResult 결과 = ballNumbers1.match(ballNumbers2);

        assertThat(결과.getStrikeCount()).isEqualTo(0);
        assertThat(결과.getBallCount()).isEqualTo(0);
    }
}
