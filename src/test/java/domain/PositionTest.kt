package domain

import domain.Position.Companion.create
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

internal class PositionTest {

    @Test
    fun `위치를 생성한다`() {
        val position = create()
        assertAll(
            Executable { assertThat(position).isInstanceOf(Position::class.java) },
            Executable { assertThat(position.value).isEqualTo(0) }
        )
    }

    @Test
    fun `위치가 증가한다`() {
        val position = create()

        val increasingPosition = position.increase()

        assertThat(increasingPosition.value).isEqualTo(1)
    }
}
