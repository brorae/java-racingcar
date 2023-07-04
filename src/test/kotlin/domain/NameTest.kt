package domain

import message.ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class NameTest {

    @ParameterizedTest
    @ValueSource(strings = ["bro", "brora", "a"])
    fun `이름을 생성한다`(value: String) {
        val name = Name(value)

        assertAll(
            Executable { assertThat(name).isInstanceOf(Name::class.java) },
            Executable { assertThat(name.value).isEqualTo(value) }
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["brorae", "broraee", "aaaaaaa"])
    fun `이름을 생성할 때 길이가 5보다 크면 예외가 발생한다`() {
        assertThatThrownBy { Name("brorae") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(CAR_NAME_LENGTH_ERROR_MESSAGE.value)
    }
}
