package domain;

import static Message.ErrorMessage.WINNER_NOT_EXIST_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import utils.NumberGenerator;

public class Cars {

    private final List<Car> value;

    private Cars(List<Car> value) {
        this.value = value;
    }

    public Cars() {
        this(new ArrayList<>());
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : value) {
            car.move(numberGenerator);
        }
    }

    public Cars calculateWinner() {
        Car winnerCar = value.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> new IllegalStateException(WINNER_NOT_EXIST_ERROR_MESSAGE.getValue()));
        List<Car> winners = value.stream()
                .filter(it -> it.hasSamePositionWith(winnerCar))
                .collect(Collectors.toList());
        return new Cars(winners);
    }

    public void add(Car car) {
        value.add(car);
    }

    public Map<String, Integer> getPositionPerCar() {
        Map<String, Integer> positionPerCar = new HashMap<>();
        for (Car car : value) {
            positionPerCar.put(car.getName(), car.getPosition());
        }
        return Collections.unmodifiableMap(positionPerCar);
    }

    public List<String> getNames() {
        return value.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
