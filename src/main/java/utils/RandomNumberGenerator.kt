package utils

import java.util.*

class RandomNumberGenerator : NumberGenerator {

    override fun generate(): Int {
        return RANDOM.nextInt(RANDOM_UPPER_BOUND)
    }

    companion object {
        private const val RANDOM_UPPER_BOUND = 10
        private val RANDOM = Random()
    }
}
