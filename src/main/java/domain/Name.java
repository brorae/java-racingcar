package domain;

import static Message.ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE;

public class Name {

    public static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validateNullAndLength(value);
        this.value = value;
    }

    private void validateNullAndLength(String value) {
        if (value == null || value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE.getValue());
        }
    }

    public String getValue() {
        return value;
    }
}
