package domain

import message.ErrorMessage.WINNER_NOT_EXIST_ERROR_MESSAGE
import utils.NumberGenerator
import java.util.*
import java.util.stream.Collectors

class Cars private constructor(private val value: MutableList<Car>) {

    constructor() : this(ArrayList<Car>()) {}

    fun move(numberGenerator: NumberGenerator) {
        for (car in value) {
            car.move(numberGenerator)
        }
    }

    fun calculateWinner(): Cars {
        val winnerCar = value.stream()
            .max(Comparator.comparingInt { obj: Car -> obj.position.value })
            .orElseThrow { IllegalStateException(WINNER_NOT_EXIST_ERROR_MESSAGE.value) }
        val winners = value.stream()
            .filter { it: Car -> it.hasSamePositionWith(winnerCar) }
            .collect(Collectors.toList())
        return Cars(winners)
    }

    fun add(car: Car) {
        value.add(car)
    }

    val positionPerCar: Map<String, Int>
        get() {
            val positionPerCar: MutableMap<String, Int> = HashMap()
            for (car in value) {
                positionPerCar[car.name.value] = car.position.value
            }
            return Collections.unmodifiableMap(positionPerCar)
        }

    val names: List<String>
        get() = value.stream()
            .map { obj: Car -> obj.name.value }
            .collect(Collectors.toList())
}
