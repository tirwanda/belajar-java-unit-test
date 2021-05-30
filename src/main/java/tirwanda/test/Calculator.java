package tirwanda.test;

public class Calculator {
    public Integer add(Integer first, Integer second) {
        return first + second;
    }

    public Integer divide(Integer first, Integer second) {
        if (second == 0 || second == null) {
            throw new IllegalArgumentException("Can not divided by zero");
        } else {
            return first / second;
        }
    }

}
