import java.util.HashMap;

/*
    Calculate all possible ways to travel from top left to bottom right in a grid, only moving down or right.
*/

public class GridTraveler {

    /**
     * GRID TRAVELER NAIVE IMPLEMENTATION
     */
    public int naiveTravel(int m, int n) {
        if (m == 0 || n == 0) { return 0; }
        if (m == 1 && n == 1) { return 1; }
        return naiveTravel(m-1, n) + naiveTravel(m, n-1);
    }

    /**
     * GRID TRAVELER DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public Long dinamicTravelMemo(int m, int n) {
        return dinamicTravelMemo(m, n, new HashMap<>());
    }
    private Long dinamicTravelMemo(int m, int n, HashMap<String, Long> memo) {
        if (m == 0 || n == 0) { return Long.valueOf(0); }
        if (m == 1 && n == 1) { return Long.valueOf(1); }
        String key = m > n ? n+"-"+m : m+"-"+n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        Long value = dinamicTravelMemo(m-1, n, memo) + dinamicTravelMemo(m, n-1, memo);
        memo.put(key, value);
        return value;
    }
        
    /**
     * GRID TRAVELER DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */
    public Long dynamicTravelTabular(int m, int n) {
        Long table [][] = new Long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = Long.valueOf(0);
            }
        }
        table[0][0] = Long.valueOf(1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Long value = Long.valueOf(table[i][j]);
                if (i < m-1) { table[i+1][j] += value; }
                if (j < n-1) { table[i][j+1] += value; }
            }
        }
        return table[m-1][n-1];
    }
}
