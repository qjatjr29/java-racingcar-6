package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

@DisplayName("자동차 모델에 대한 테스트")
class CarTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void initCar() {
        // given
        String carName = "beom";

        // when
        Car car = new Car(carName);

        // then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 5글자 초과라면 생성하지 않고 예외를 호출한다.")
    void init_CarNameLengthThan5_ThrownException() {
        // given
        String carName = "beomsic";

        // when
        // then
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름으로 빈 문자열이 들어오면 예외를 호출한다.")
    void init_CarNameIsEmpty_ThrownException() {
        // given
        String carName = "";

        // when
        // then
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }
}