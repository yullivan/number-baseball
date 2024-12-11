package numberbaseballv2;

public class BallNumber {
    private int position;
    private int value;

    public BallNumber(int position, int value) {
        if (position < Constants.MIN_POSITION || position > Constants.MAX_POSITION) {
            throw new IllegalArgumentException("위치 값은 1과 3 사이");
        }
        if (value < Constants.MIN_VALUE || value > Constants.MAX_VALUE) {
            throw new IllegalArgumentException("숫자 값은 1과 9 사이");
        }
        this.position = position;
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    public MatchResult match(BallNumber other) {
        if (this.position == other.position && this.value == other.value) {
            return MatchResult.STRIKE;
        }
        if (this.value == other.value) {
            return MatchResult.BALL;
        }
        return MatchResult.NOTHING;
    }
}
