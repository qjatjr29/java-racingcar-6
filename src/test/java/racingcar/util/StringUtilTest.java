package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringUtilTest {

    @ParameterizedTest()
    @MethodSource("inputStringProvider")
    @DisplayName("주어진 구분자를 통해 문자열 구분")
    void splitByDelimiter(String inputString, String delimiter, int expectedCount) {
        // given
        // when
        String[] results = StringUtil.splitByDelimiter(inputString, delimiter);

        // then
        assertAll(
                () -> assertThat(results).isNotEmpty(),
                () -> assertThat(results).hasSize(expectedCount)
        );
    }


    private static Stream<Arguments> inputStringProvider() {
        return Stream.of(
                Arguments.of("test,beom,sic,hi", "," , 4),
                Arguments.of("test/beom/sic/hi", "\\/" , 4),
                Arguments.of("test,beom,sic", "," , 3),
                Arguments.of("test,hi", "," , 2),
                Arguments.of("test beom sic hi", " ", 4)
        );
    }


}
