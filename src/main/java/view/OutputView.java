package view;

import static message.GameMessage.FINAL_RESULT_MESSAGE;
import static message.GameMessage.GAME_RESULT_MESSAGE;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String WINNER_DELIMITER = ",";
    private static final String CAR_SEPARATOR = " : ";
    private static final String CAR_POSITION_CHARACTER = "-";

    private OutputView() {

    }

    public static void printRoundResult(Map<String, Integer> positionPerCar) {
        System.out.println();
        System.out.println(GAME_RESULT_MESSAGE.getValue());
        for (String car : positionPerCar.keySet()) {
            Integer position = positionPerCar.get(car);
            System.out.println(car + CAR_SEPARATOR + CAR_POSITION_CHARACTER.repeat(position));
        }
    }

    public static void printWinner(List<String> winners) {
        System.out.println();
        System.out.println(String.join(WINNER_DELIMITER, winners) + (FINAL_RESULT_MESSAGE.getValue()));
    }

    public static void printMessage(String message) {
        System.out.println();
        System.out.println(message);
    }
}
