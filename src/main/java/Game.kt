import controller.RaceController

object Game {

    @JvmStatic
    fun main(args: Array<String>) {
        val raceController = RaceController()
        raceController.start()
    }
}
