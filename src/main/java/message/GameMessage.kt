package message

enum class GameMessage(val value: String) {
    CAR_NAMES_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    TRY_COUNT_MESSAGE("시도할 횟수는 몇회인가요?"),
    GAME_RESULT_MESSAGE("실행결과"),
    FINAL_RESULT_MESSAGE("가 최종 우승했습니다.");
}
