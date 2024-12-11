package numberbaseballv2;

import java.util.*;

public class GameController {
    private static final Scanner scanner = new Scanner(System.in);

    // 컴퓨터용 BallNumber 3개를 만들어 내는 함수
    public static List<BallNumber> getComputerBallNumberList() {
        List<Integer> computerNumbers = getComputerNumbers();
        List<BallNumber> computerBallNumbersList = mapToBallNumber(computerNumbers);
        return computerBallNumbersList;
    }

    // 컴퓨터 숫자 세 개를 랜덤으로 만들어내는 함수
    private static List<Integer> getComputerNumbers() {
        // 1부터 9까지 들어 있는 리스트 만들기
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // 그 리스트를 섞기
        Collections.shuffle(integers);
        // 섞인 리스트에서 맨 앞의 세 개만 골라내기
        List<Integer> randomNumbers = integers.subList(0, 3);

        return randomNumbers;
    }

    // 정수들을 BallNumber로 만들어 주는 함수
    private static List<BallNumber> mapToBallNumber(List<Integer> integers) {
        List<BallNumber> ballNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ballNumberList.add(new BallNumber(i + 1, integers.get(i)));
        }
        return ballNumberList;
    }

    // 유저용 BallNumber 3개를 만들어 내는 함수
    public static List<BallNumber> getUserBallNumberList() {
        List<Integer> userInputs = getUserInputs();
        List<BallNumber> userBallNumberList = mapToBallNumber(userInputs);
        return userBallNumberList;
    }

    // 유저에게 숫자 3개를 입력받는 함수
    private static List<Integer> getUserInputs() {
        List<Integer> userInputs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "번째 숫자를 입력해 주세요: ");
            int userInput = Integer.parseInt(scanner.nextLine());
            userInputs.add(userInput);
        }
        return userInputs;
    }

    // 결과를 출력하는 함수
    public static void print(GameResult gameResult) {
        System.out.println(gameResult.getStrikeCount() + " strike " + gameResult.getBallCount() + " ball입니다.");
    }
}
