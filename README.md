# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 요구사항
- 자동차의 이름을 입력받는다.
  - 자동차의 이름은 `,`를 기준으로 분리한다.
  - 자동차의 이름의 길이는 5자 이하이다.
- 자동차를 몇번 이동시킬지 입력받는다.
- 전진 조건은 0에서 9사이의 랜덤값을 통해 정해진다.
  - 4 이상일 경우, 전진
  - 3 이하일 경우, 정지
- 이동결과를 매번 출력한다.
- 자동차 경주 후 누가 우승했는지 출력한다.
```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```
