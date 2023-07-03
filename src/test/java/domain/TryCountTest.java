package domain;

import static Message.ErrorMessage.TRY_COUNT_FORMAT_ERROR_MESSAGE;
import static Message.ErrorMessage.TRY_COUNT_NEGATIVE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {


    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3", "2147483647"})
    void 시도횟수를_생성한다(String value) {
        var tryCount = TryCount.from(value);

        assertThat(tryCount).isInstanceOf(TryCount.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "1a", "a2", "1a1", "2147483648"})
    void 시도횟수를_생성할_때_INT_형이_아니면_예외가_발생한다(String value) {
        assertThatThrownBy(() -> TryCount.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRY_COUNT_FORMAT_ERROR_MESSAGE.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-100", "-1000"})
    void 시도횟수를_생성할_때_음수이면_예외가_발생한다(String value) {
        assertThatThrownBy(() -> TryCount.from(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TRY_COUNT_NEGATIVE_ERROR_MESSAGE.getValue());
    }

    @Test
    void 시도횟수가_0이면_TRUE_를_반환한다() {
        TryCount tryCount = TryCount.from("0");

        assertThat(tryCount.isZero()).isTrue();
    }

    @Test
    void 시도횟수가_0이_아니면_TRUE_를_반환한다() {
        TryCount tryCount = TryCount.from("1");

        assertThat(tryCount.isZero()).isFalse();
    }

    @Test
    void 시도횟수가_감소한다() {
        TryCount tryCount = TryCount.from("2");

        TryCount oneTryCount = tryCount.decrease();
        TryCount zeroTryCount = tryCount.decrease();

        assertAll(
                () -> assertThat(oneTryCount.isZero()).isFalse(),
                () -> assertThat(zeroTryCount.isZero()).isTrue()
        );
    }
}
