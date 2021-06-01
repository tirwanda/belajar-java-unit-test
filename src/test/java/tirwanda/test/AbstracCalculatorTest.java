package tirwanda.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import tirwanda.test.resolver.RandomParameterResolver;

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class AbstracCalculatorTest {

    protected Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        System.out.println("Before Each");
    }
}
