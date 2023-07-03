package controller;

import static Message.ErrorMessage.GAME_ERROR_MESSAGE;

import domain.Car;
import domain.Cars;
import domain.TryCount;
import java.io.IOException;
import java.util.List;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RaceController {

    public static void main(String[] args) {
        try {
            Cars cars = registerCars();
            playGame(cars);
            showWinners(cars);
        } catch (IOException e) {
            throw new IllegalStateException(GAME_ERROR_MESSAGE.getValue());
        } catch (RuntimeException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private static Cars registerCars() throws IOException {
        List<String> carNames = InputView.inputCarNames();
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static void playGame(Cars cars) throws IOException {
        TryCount count = TryCount.from(InputView.inputTryCount());
        while (!count.isZero()) {
            cars.move(new RandomNumberGenerator());
            count = count.decrease();
            OutputView.printRoundResult(cars.getPositionPerCar());
        }
    }

    private static void showWinners(Cars cars) {
        Cars winners = cars.calculateWinner();
        OutputView.printWinner(winners.getNames());
    }
}
