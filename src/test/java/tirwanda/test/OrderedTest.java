package tirwanda.test;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {
    private Integer count = 0;

    @BeforeAll
    void beforeAll() {

    }

    @AfterAll
    void afterAll() {

    }

    @Test
    @Order(2)
    void test2() {
        count++;
        System.out.println(count);
    }

    @Test
    @Order(3)
    void test3() {
        count++;
        System.out.println(count);
    }

    @Test
    @Order(1)
    void test1() {
        count++;
        System.out.println(count);
    }
}
