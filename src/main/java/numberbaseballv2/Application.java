package numberbaseballv2;

public class Application {

    public static void main(String[] args) {
        BallNumbers computerBallNumbers = new BallNumbers(GameController.getComputerBallNumberList());

        while (true) {
            BallNumbers userBallNumbers = new BallNumbers(GameController.getUserBallNumberList());

            GameResult gameResult = computerBallNumbers.match(userBallNumbers);

            GameController.print(gameResult);

            if (gameResult.isGameOver()) {
                break;
            }
        }
    }
}
