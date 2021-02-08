import java.util.HashMap;

public class Fibonacci {
    public Fibonacci() {

    }

    public Long fib(Integer n) {
        return fib(Long.valueOf(n), new HashMap<>());
    }

    private Long fib(Long n, HashMap<Long, Long> memoization) {
        if (memoization.containsKey(n)) {
            return memoization.get(n);
        }
        if (n <= 2) { return Long.valueOf(1); }
        Long value = fib(n-1, memoization) + fib(n-2, memoization);
        memoization.put(n, value);
        return value;
    }
}
 