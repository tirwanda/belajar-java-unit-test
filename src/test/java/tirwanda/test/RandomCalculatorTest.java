package tirwanda.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.api.extension.Extensions;
//import tirwanda.test.resolver.RandomParameterResolver;

import java.util.List;
import java.util.Random;

//@Extensions({
//        @ExtendWith(RandomParameterResolver.class)
//})
public class RandomCalculatorTest extends AbstracCalculatorTest {

//    private Calculator calculator = new Calculator();

    @Test
    void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }


    @RepeatedTest(
            value = 5,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    void testRandomRepeat(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test Random Calculator")
    @RepeatedTest(
            value = 5,
            name = "{displayName}"
    )
    void testRandomRepeatInfo(TestInfo testInfo, Random random, RepetitionInfo repetitionInfo) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        System.out.println(testInfo.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());
        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Test Calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testWithParameter(int value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

    public static List<Integer> parameterSource() {
        return List.of(1, 2, 3, 4, 5);
    }

    @DisplayName("Test Calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @MethodSource({"parameterSource"})
    void testWithMethodSource(Integer value) {
        var expected = value + value;
        var result = calculator.add(value, value);
        Assertions.assertEquals(expected, result);
    }
}
