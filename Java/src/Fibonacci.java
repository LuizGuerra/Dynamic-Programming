import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Fibonacci {

    /**
     * FIBONACCI NAIVE IMPLEMENTATION
     */
    public int naiveFib(int n) {
        if (n < 2) { return 1; }
        return naiveFib(n-1) + naiveFib(n-2);
    }

    /**
     * FIBONACCI DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public Long dynamicFibMemo(Integer n) {
        return dynamicFibMemo(Long.valueOf(n), new HashMap<>());
    }
    private Long dynamicFibMemo(Long n, HashMap<Long, Long> memoization) {
        if (memoization.containsKey(n)) {
            return memoization.get(n);
        }
        if (n <= 2) { return Long.valueOf(1); }
        Long value = dynamicFibMemo(n-1, memoization) + dynamicFibMemo(n-2, memoization);
        memoization.put(n, value);
        return value;
    }

    /**
     * FIBONACCI DYNAMIC IMPLEMENTATION
     * USING TABULTION
     */
    public Long dynamicFibTabular(int n) {
        Long list [] = new Long [n+1];
        for (int i = 0; i < n+1; i++) { list[i] = Long.valueOf(0); }
        list[1] = Long.valueOf(1);
        for (int i = 0; i < n; i++) {
            list[i+1] += list[i];
            if (i+2 <= n) { list[i+2] += list[i]; }
        }
        return list[n];
    }
}
 