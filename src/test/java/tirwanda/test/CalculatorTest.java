package tirwanda.test;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import tirwanda.test.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayName("Test For Calculator class")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @BeforeAll // Method-nya harus static
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll // Method-nya harus static
    public static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each");
    }

    @Test
//    @DisplayName("Test Scenario success for method add(Integer, Integer)")
    public void testAddSuccess() {
        var result = calculator.add(10,10);
        assertEquals(20, result);

        // Manual Test -> Not Recommended
//        if (result != 20) {
//            throw new RuntimeException("Test Add fail");
//        }
    }

    @Test
//    @DisplayName("Testing Scenario success for method divide(Integer, Integer)")
    public void testDivideSuccess() {
        var result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
//    @DisplayName("Testing Scenario fail for method divide(Integer, Integer)")
    public void testDivideFail() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(100, 0));
    }

    @Test
    @Disabled
    public void commingSoon() {

    }

    @Test
    public void testAborted() {
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test di batalkan karena bukan DEV");
        }
    }
}
