package tirwanda.test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {
    private Queue<String> queue;

    @Nested
    @DisplayName("When New")
    public class whenNew {
        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("When offer, size must be 1")
        void offerNewData() {
            queue.offer("Edho");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("When Offer 2 Data, Size must be 2")
        void offerMoreData() {
            queue.offer("Dwi");
            queue.offer("Tirwanda");
            Assertions.assertEquals(2, queue.size());
        }
    }
}
