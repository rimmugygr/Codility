package lesson.lesson10_prime_and_composite_numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountFactorsTest {

    @ParameterizedTest
    @MethodSource("date")
    void solution(int expected, int input) {
            assertEquals(expected, CountFactors.solution(input));
    }

    private static Stream<Arguments> date() {
        return Stream.of(
                Arguments.of(1,1),
                Arguments.of(2,2),
                Arguments.of(3,9),
                Arguments.of(8,24),
                Arguments.of(9,36),
                Arguments.of(2,41)

                );
    }

}