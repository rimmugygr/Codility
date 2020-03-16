package lesson.lesson10_prime_and_composite_numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinPerimeterRectangleTest {

    @ParameterizedTest
    @MethodSource("date")
    void solution(int expected, int input) {
        assertEquals(expected, MinPerimeterRectangle.solution(input));
    }

    private static Stream<Arguments> date() {
        return Stream.of(
                Arguments.of(4,1),
                Arguments.of(22,30)

        );
    }
}