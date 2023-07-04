package domain

import message.ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import utils.TestNumberGenerator

internal class CarTest {

    @Test
    fun `자동차를 생성한다`() {
        val car = Car("bro")

        assertThat(car).isInstanceOf(Car::class.java)
    }

    @Test
    fun `자동차의 이름이 5자를 넘으면 예외가 발생한다`() {
        assertThatThrownBy { Car("brorae") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(CAR_NAME_LENGTH_ERROR_MESSAGE.value)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `자동차가 움직인다`(value: Int) {
        val car = Car("bro")

        car.move(TestNumberGenerator(value))

        assertThat(car.position.value).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `자동차가 움직이지 않는다`(value: Int) {
        val car = Car("bro")

        car.move(TestNumberGenerator(value))

        assertThat(car.position).isEqualTo(Position.create())
    }

    @Test
    fun `자동차가 같은 위치에 있음을 확인한다`() {
        val car1 = Car("bro1")
        val car2 = Car("bro2")

        assertThat(car1.hasSamePositionWith(car2)).isTrue
    }

    @Test
    fun `자동차가 같은 위치에 있지 않음을 확인한다`() {
        val car1 = Car("bro1")
        val car2 = Car("bro2")

        car1.move(TestNumberGenerator(4))

        assertThat(car1.hasSamePositionWith(car2)).isFalse
    }
}
