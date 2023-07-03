package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import Message.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"bro", "brora", "a"})
    void 이름을_생성한다(String value) {
        var name = new Name(value);

        assertAll(
                () -> assertThat(name).isInstanceOf(Name.class),
                () -> assertThat(name.getValue()).isEqualTo(value)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"brorae", "broraee", "aaaaaaa"})
    void 이름을_생성할_때_길이가_5보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> new Name("brorae"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE.getValue());
    }

    @Test
    void 이름을_생성할_때_null이_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE.getValue());
    }
}
