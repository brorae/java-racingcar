package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import utils.TestNumberGenerator;

class CarsTest {

    @Test
    void 자동차들을_생성한다() {
        var cars = new Cars();

        assertThat(cars).isInstanceOf(Cars.class);
    }

    @Test
    void 자동차들이_움직인다() {
        Cars cars = new Cars();
        cars.add(new Car("bro1"));
        cars.add(new Car("bro2"));

        cars.move(new TestNumberGenerator(4));
        Map<String, Integer> positionPerCar = cars.getPositionPerCar();

        assertAll(
                () -> assertThat(positionPerCar.get("bro1")).isEqualTo(1),
                () -> assertThat(positionPerCar.get("bro2")).isEqualTo(1)
        );
    }

    @Test
    void 자동차들이_움직이지_않는다() {
        Cars cars = new Cars();
        cars.add(new Car("bro1"));
        cars.add(new Car("bro2"));

        cars.move(new TestNumberGenerator(3));
        Map<String, Integer> positionPerCar = cars.getPositionPerCar();

        assertAll(
                () -> assertThat(positionPerCar.get("bro1")).isEqualTo(0),
                () -> assertThat(positionPerCar.get("bro2")).isEqualTo(0)
        );
    }

    @Test
    void 우승자를_계산한다() {
        Cars cars = new Cars();
        Car bro1 = new Car("bro1");
        Car bro2 = new Car("bro2");
        Car bro3 = new Car("bro3");
        bro1.move(new TestNumberGenerator(4));
        bro3.move(new TestNumberGenerator(4));
        cars.add(bro1);
        cars.add(bro2);
        cars.add(bro3);

        Cars winners = cars.calculateWinner();
        List<String> names = winners.getNames();

        assertThat(names).containsExactly("bro1", "bro3");
    }
}
