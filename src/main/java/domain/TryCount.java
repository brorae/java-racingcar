package domain;

import static message.ErrorMessage.TRY_COUNT_FORMAT_ERROR_MESSAGE;
import static message.ErrorMessage.TRY_COUNT_NEGATIVE_ERROR_MESSAGE;

public class TryCount {

    private final int value;

    private TryCount(int value) {
        validateNegative(value);
        this.value = value;
    }

    public static TryCount from(String value) {
        try {
            return new TryCount(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_FORMAT_ERROR_MESSAGE.getValue());
        }
    }

    private void validateNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(TRY_COUNT_NEGATIVE_ERROR_MESSAGE.getValue());
        }
    }

    public TryCount decrease() {
        return new TryCount(value - 1);
    }

    public boolean isZero() {
        return value == 0;
    }
}
