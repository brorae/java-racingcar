package domain

import message.ErrorMessage.TRY_COUNT_FORMAT_ERROR_MESSAGE
import message.ErrorMessage.TRY_COUNT_NEGATIVE_ERROR_MESSAGE

class TryCount private constructor(value: Int) {
    private val value: Int

    init {
        validateNegative(value)
        this.value = value
    }

    private fun validateNegative(value: Int) {
        require(value >= 0) { TRY_COUNT_NEGATIVE_ERROR_MESSAGE.value }
    }

    fun decrease(): TryCount {
        return TryCount(value - 1)
    }

    val isZero: Boolean
        get() = value == 0

    companion object {
        @JvmStatic
        fun from(value: String): TryCount {
            return try {
                TryCount(value.toInt())
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(TRY_COUNT_FORMAT_ERROR_MESSAGE.value)
            }
        }
    }
}
