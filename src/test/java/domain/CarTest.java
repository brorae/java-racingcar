package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Message.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.TestNumberGenerator;

class CarTest {

    @Test
    void 자동차를_생성한다() {
        var car = new Car("bro");

        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void 자동차의_이름이_5자를_넘으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("brorae"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE.getValue());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차가_움직인다(int value) {
        Car car = new Car("bro");

        car.move(new TestNumberGenerator(value));

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차가_움직이지_않는다(int value) {
        Car car = new Car("bro");

        car.move(new TestNumberGenerator(value));

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차가_같은_위치에_있음을_확인한다() {
        Car car1 = new Car("bro1");
        Car car2 = new Car("bro2");

        assertThat(car1.hasSamePositionWith(car2)).isTrue();
    }

    @Test
    void 자동차가_같은_위치에_있지_않음을_확인한다() {
        Car car1 = new Car("bro1");
        Car car2 = new Car("bro2");
        car1.move(new TestNumberGenerator(4));

        assertThat(car1.hasSamePositionWith(car2)).isFalse();
    }
}
