package view

import message.GameMessage
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.String.valueOf
import java.util.*
import java.util.stream.Collectors

object InputView {

    private val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    private const val CAR_NAME_DELIMITER = ","

    @JvmStatic
    @Throws(IOException::class)
    fun inputCarNames(): List<String> {
        println(GameMessage.CAR_NAMES_MESSAGE.value)
        return splitCarNames()
    }

    @JvmStatic
    @Throws(IOException::class)
    fun inputTryCount(): String {
        println(GameMessage.TRY_COUNT_MESSAGE.value)
        return bufferedReader.readLine()
    }

    @Throws(IOException::class)
    private fun splitCarNames(): List<String> {
        val line = bufferedReader.readLine()
        return line.split(CAR_NAME_DELIMITER)
    }
}
