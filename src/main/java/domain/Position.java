package domain;

import static message.ErrorMessage.POSITION_NEGATIVE_ERROR_MESSAGE;

import java.util.Objects;

public class Position {

    private final int value;

    private Position(int value) {
        validateNegative(value);
        this.value = value;
    }

    public static Position create() {
        return new Position(0);
    }

    private void validateNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(POSITION_NEGATIVE_ERROR_MESSAGE.getValue());
        }
    }

    public Position increase() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
