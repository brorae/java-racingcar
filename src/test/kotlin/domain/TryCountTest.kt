package domain

import domain.TryCount.Companion.from
import message.ErrorMessage
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class TryCountTest {

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "2", "3", "2147483647"])
    fun `시도횟수를 생성한다`(value: String) {
        val tryCount = from(value)

        assertThat(tryCount).isInstanceOf(TryCount::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "b", "c", "1a", "a2", "1a1", "2147483648"])
    fun `시도횟수를 생성할 때 INT형이 아니면 예외가발생한다`(value: String) {
        assertThatThrownBy { from(value) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessage.TRY_COUNT_FORMAT_ERROR_MESSAGE.value)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-2", "-100", "-1000"])
    fun `시도횟수를 생성할 때 음수이면 예외가 발생한다`(value: String) {
        assertThatThrownBy { from(value) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessage.TRY_COUNT_NEGATIVE_ERROR_MESSAGE.value)
    }

    @Test
    fun `시도횟수가 0이면 TRUE를 반환한다`() {
        val tryCount = from("0")

        assertThat(tryCount.isZero).isTrue
    }

    @Test
    fun `시도횟수가 0이 아니면 TRUE를 반환한다`() {
        val tryCount = from("1")

        assertThat(tryCount.isZero).isFalse
    }

    @Test
    fun `시도횟수가 감소한다`() {
        val tryCount = from("2")

        val oneTryCount = tryCount.decrease()
        val zeroTryCount = oneTryCount.decrease()

        assertAll(
            Executable { assertThat(oneTryCount.isZero).isFalse() },
            Executable { assertThat(zeroTryCount.isZero).isTrue() }
        )
    }
}
