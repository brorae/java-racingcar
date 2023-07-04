package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import utils.TestNumberGenerator

internal class CarsTest {

    @Test
    fun `자동차들을 생성한다`() {
        val cars = Cars()

        assertThat(cars).isInstanceOf(Cars::class.java)
    }

    @Test
    fun `자동차들이 움직인다`() {
        val cars = Cars()
        cars.add(Car("bro1"))
        cars.add(Car("bro2"))

        cars.move(TestNumberGenerator(4))
        val positionPerCar = cars.positionPerCar

        assertAll(
            Executable { assertThat(positionPerCar["bro1"]).isEqualTo(1) },
            Executable { assertThat(positionPerCar["bro2"]).isEqualTo(1) }
        )
    }

    @Test
    fun `자동차들이 움직이지 않는다`() {
        val cars = Cars()
        cars.add(Car("bro1"))
        cars.add(Car("bro2"))

        cars.move(TestNumberGenerator(3))
        val positionPerCar = cars.positionPerCar

        assertAll(
            Executable { assertThat(positionPerCar["bro1"]).isEqualTo(0) },
            Executable { assertThat(positionPerCar["bro2"]).isEqualTo(0) }
        )
    }

    @Test
    fun `우승자를 계산한다`() {
        val cars = Cars()
        val bro1 = Car("bro1")
        val bro2 = Car("bro2")
        val bro3 = Car("bro3")
        bro1.move(TestNumberGenerator(4))
        bro3.move(TestNumberGenerator(4))
        cars.add(bro1)
        cars.add(bro2)
        cars.add(bro3)

        val winners = cars.calculateWinner()
        val names = winners.names

        assertThat(names).containsExactly("bro1", "bro3")
    }
}
