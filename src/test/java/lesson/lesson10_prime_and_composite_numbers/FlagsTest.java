package lesson.lesson10_prime_and_composite_numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FlagsTest {

    @ParameterizedTest
    @MethodSource("date")
    void solution(int expected, int[] input) {
        assertEquals(expected, Flags.solution(input));
    }

    private static Stream<Arguments> date() {
        return Stream.of(
                Arguments.of(3, new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}),
                Arguments.of(0, new int[]{5}),
                Arguments.of(0, new int[]{3,2,1})
        );
    }


}