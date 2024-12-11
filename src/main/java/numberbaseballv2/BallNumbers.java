package numberbaseballv2;

import java.util.ArrayList;
import java.util.List;

public class BallNumbers {
    List<BallNumber> numbers = new ArrayList<>();

    public BallNumbers(List<BallNumber> numbers) {
        this.numbers = numbers;
    }

    // 아래 생성자를 만들어 두면 오브젝트 만들 때 편하긴 하지만
    // BallNumber 오브젝트를 만드는 책임까지 떠안게 되는 것
//    public BallNumbers(List<Integer> numbers) {
//        for (int i = 0; i < numbers.size(); i++) {
//            this.numbers.add(new BallNumber(i + 1, numbers.get(i)));
//        }
//    }

    MatchResult match(BallNumber otherBallNumber) {
        for (BallNumber thisBallNumber : numbers) {
            MatchResult matchResult = thisBallNumber.match(otherBallNumber);
            if (matchResult != MatchResult.NOTHING) {
                return matchResult;
            }
        }
        return MatchResult.NOTHING;
    }

    List<Integer> match(BallNumbers other) {
        int strikeCount = 0;
        int ballCount = 0;
        for (BallNumber ballNumber1 : this.numbers) {
            for (BallNumber ballNumber2 : other.numbers) {
                MatchResult 비교결과 = ballNumber1.match(ballNumber2);
                if (비교결과 == MatchResult.STRIKE) {
                    strikeCount += 1;
                } else if (비교결과 == MatchResult.BALL) {
                    ballCount += 1;
                }
            }
        }

        return List.of(strikeCount, ballCount);
    }
}
