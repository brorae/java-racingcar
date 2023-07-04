package domain

import message.ErrorMessage
import java.util.*

class Position private constructor(val value: Int) {

    init {
        validateNegative(value)
    }

    private fun validateNegative(value: Int) {
        require(value >= 0) { ErrorMessage.POSITION_NEGATIVE_ERROR_MESSAGE.value }
    }

    fun increase(): Position {
        return Position(value + 1)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val position = o as Position
        return value == position.value
    }

    override fun hashCode(): Int {
        return Objects.hash(value)
    }

    companion object {
        @JvmStatic
        fun create(): Position {
            return Position(0)
        }
    }
}
