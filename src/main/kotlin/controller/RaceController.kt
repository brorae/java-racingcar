package controller

import domain.Car
import domain.Cars
import domain.TryCount.Companion.from
import message.ErrorMessage
import utils.RandomNumberGenerator
import view.InputView.inputCarNames
import view.InputView.inputTryCount
import view.OutputView.printMessage
import view.OutputView.printRoundResult
import view.OutputView.printWinner
import java.io.IOException

class RaceController {

    fun start() {
        try {
            val cars = registerCars()
            playGame(cars)
            showWinners(cars)
        } catch (e: IOException) {
            throw IllegalStateException(ErrorMessage.GAME_ERROR_MESSAGE.value)
        } catch (e: RuntimeException) {
            printMessage(e.message!!)
        }
    }

    @Throws(IOException::class)
    private fun registerCars(): Cars {
        val carNames = inputCarNames()
        val cars = Cars()
        for (carName in carNames) {
            cars.add(Car(carName))
        }
        return cars
    }

    @Throws(IOException::class)
    private fun playGame(cars: Cars) {
        var count = from(inputTryCount())
        while (!count.isZero) {
            cars.move(RandomNumberGenerator())
            count = count.decrease()
            printRoundResult(cars.positionPerCar)
        }
    }

    private fun showWinners(cars: Cars) {
        val winners = cars.calculateWinner()
        printWinner(winners.names)
    }
}
