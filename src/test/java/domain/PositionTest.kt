package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 위치를_생성한다() {
        var position = Position.create();

        assertAll(
                () -> assertThat(position).isInstanceOf(Position.class),
                () -> assertThat(position.getValue()).isEqualTo(0)
        );
    }

    @Test
    void 위치가_증가한다() {
        Position position = Position.create();

        Position increasingPosition = position.increase();

        assertThat(increasingPosition.getValue()).isEqualTo(1);
    }
}
