package message

enum class ErrorMessage(val value: String) {
    WINNER_NOT_EXIST_ERROR_MESSAGE("[ERROR] 우승자가 존재하지 않습니다."),
    CAR_NAME_LENGTH_ERROR_MESSAGE("[ERROR] 자동차의 이름은 5자 미만입니다."),
    POSITION_NEGATIVE_ERROR_MESSAGE("[ERROR] 위치는 0 이상이어야합니다."),
    TRY_COUNT_NEGATIVE_ERROR_MESSAGE("[ERROR] 시도횟수는 0 이상이어야합니다."),
    TRY_COUNT_FORMAT_ERROR_MESSAGE("[ERROR] 시도횟수는 숫자이어야합니다."),
    GAME_ERROR_MESSAGE("[ERROR] 게임 진행 중 예외가 발생했습니다.");
}
