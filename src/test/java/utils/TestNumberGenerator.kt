package utils

class TestNumberGenerator(private val number: Int) : NumberGenerator {

    override fun generate(): Int {
        return number
    }
}
