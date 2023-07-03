package view;

import static message.GameMessage.CAR_NAMES_MESSAGE;
import static message.GameMessage.TRY_COUNT_MESSAGE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static final String CAR_NAME_DELIMITER = ",";

    private InputView() {

    }

    public static List<String> inputCarNames() throws IOException {
        System.out.println(CAR_NAMES_MESSAGE.getValue());
        return splitCarNames();
    }

    public static String inputTryCount() throws IOException {
        System.out.println(TRY_COUNT_MESSAGE.getValue());
        return bufferedReader.readLine();
    }

    private static List<String> splitCarNames() throws IOException {
        String line = bufferedReader.readLine();
        String[] carNames = line.split(CAR_NAME_DELIMITER);
        return Arrays.stream(carNames)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
