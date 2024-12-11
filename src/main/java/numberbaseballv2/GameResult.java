package numberbaseballv2;

public class GameResult {
    private int strikeCount;
    private int ballCount;

    public GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void count(MatchResult matchResult) {
        if (matchResult == MatchResult.STRIKE) {
            strikeCount = strikeCount + 1;
        }
        if (matchResult == MatchResult.BALL) {
            ballCount = ballCount + 1;
        }
    }

    public boolean isGameOver() {
        return strikeCount == 3;
    }
}
