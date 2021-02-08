import java.util.HashMap;

/*
    Calculate all possible ways to travel from top left to bottom right in a grid, only moving down or right.
*/

public class GridTraveler {

    public GridTraveler() {

    }

    public int naiveTravel(int m, int n) {
        if (m == 0 || n == 0) { return 0; }
        if (m == 1 && n == 1) { return 1; }
        return naiveTravel(m-1, n) + naiveTravel(m, n-1);
    }

    public Long dinamicTravel(int m, int n) {
        return dinamicTravel(m, n, new HashMap<>());
    }
    
    private Long dinamicTravel(int m, int n, HashMap<String, Long> memo) {
        if (m == 0 || n == 0) { return Long.valueOf(0); }
        if (m == 1 && n == 1) { return Long.valueOf(1); }
        String key = m > n ? n+"-"+m : m+"-"+n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        Long value = dinamicTravel(m-1, n, memo) + dinamicTravel(m, n-1, memo);
        memo.put(key, value);
        return value;
    }
}
