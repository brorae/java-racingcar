package domain

import message.ErrorMessage

class Name(val value: String) {

    init {
        validateNullAndLength(value)
    }

    private fun validateNullAndLength(value: String) {
        require(value.length <= MAX_NAME_LENGTH) { ErrorMessage.CAR_NAME_LENGTH_ERROR_MESSAGE.value }
    }

    companion object {
        const val MAX_NAME_LENGTH = 5
    }
}
