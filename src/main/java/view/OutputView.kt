package view

import message.GameMessage.FINAL_RESULT_MESSAGE
import message.GameMessage.GAME_RESULT_MESSAGE
import java.lang.String.*

object OutputView {

    private const val WINNER_DELIMITER = ","
    private const val CAR_SEPARATOR = " : "
    private const val CAR_POSITION_CHARACTER = "-"

    @JvmStatic
    fun printRoundResult(positionPerCar: Map<String, Int>) {
        println()
        println(GAME_RESULT_MESSAGE.value)
        for (entry in positionPerCar) {
            println(entry.key + CAR_SEPARATOR + CAR_POSITION_CHARACTER.repeat(entry.value))
        }
    }

    @JvmStatic
    fun printWinner(winners: List<String>) {
        println()
        println(join(WINNER_DELIMITER, winners) + FINAL_RESULT_MESSAGE.value)
    }

    @JvmStatic
    fun printMessage(message: String) {
        println()
        println(message)
    }
}
