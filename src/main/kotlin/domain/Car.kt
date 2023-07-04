package domain

import domain.Position.Companion.create
import utils.NumberGenerator

class Car private constructor(val name: Name, var position: Position) {

    constructor(name: String) : this(Name(name), create()) {}

    fun move(numberGenerator: NumberGenerator) {
        val number = numberGenerator.generate()
        if (number >= MOVABLE_NUMBER_LOWER_BOUND) {
            position = position.increase()
        }
    }

    fun hasSamePositionWith(other: Car): Boolean {
        return position == other.position
    }

    companion object {
        const val MOVABLE_NUMBER_LOWER_BOUND = 4
    }
}
