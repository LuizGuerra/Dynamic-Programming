import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
    Verify if is possible to target word be constructed by concatenating elements of the string array.
*/

public class Construct {
    
    /**
     * ===============================================================
     *                         CAN CONSTRUCT           
     *                        decision problem                        
     * ===============================================================
     */

    /**
     * CAN CONSTRUCT NAIVE IMPLEMENTATION
     */
    public boolean naiveCanConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) { return true; }
        for (String subWord : wordBank) {
            if (!target.startsWith(subWord)) { continue; }
            if (naiveCanConstruct(target.replaceFirst(subWord, ""), wordBank)) {
                return true;
            } 
        }
        return false;
    }
    
    /**
     * CAN CONSTRUCT DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public boolean dynamicCanConstructMemo(String target, List<String> wordBank) {
        return dynamicCanConstructMemo(target, wordBank, new HashMap<>());
    }
    private boolean dynamicCanConstructMemo(String target, List<String> wordBank, HashMap<String, Boolean> memo) {
        if (memo.containsKey(target)) { return memo.get(target); }
        if (target.isEmpty()) { return true; }
        for (String subWord : wordBank) {
            if (!target.startsWith(subWord)) { continue; }
            if (dynamicCanConstructMemo(target.replaceFirst(subWord, ""), wordBank, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }
    
    /**
     * CAN CONSTRUCT DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */
    public boolean dynamicCanConstructTabular(String target, List<String> wordBank) {
        List<Boolean> tabulation = new ArrayList<>();
        tabulation.add(true);
        for (int i = 0; i < target.length(); i++) { tabulation.add(false); }

        for (int i = 0; i < target.length(); i++) {
            if (!tabulation.get(i)) { continue; }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (word.startsWith(prefix)) {
                    tabulation.set(i + prefix.length(), true);
                }
                if (tabulation.get(target.length())) { return true; }
            }
        }
        return false;
    }
    
    /**
     * ===============================================================
     *                          COUNT CONSTRUCT                         
     *                       combinatoric problem                     
     * ===============================================================
     */

    public int naiveCountConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) { return 1; }
        int sum = 0;
        for (String prefix : wordBank) {
            if (!target.startsWith(prefix)) { continue; }
            sum += naiveCountConstruct(target.replaceFirst(prefix, ""), wordBank);
        }
        return sum;
    }

    /**
     * HOW COUNT DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public Integer dynamicCountConstructMemo(String target, List<String> wordBank) {
        return dynamicCountConstructMemo(target, wordBank, new HashMap<>());
    }
    private Integer dynamicCountConstructMemo(String target, List<String> wordBank, HashMap<String, Integer> memo) {
        if (memo.containsKey(target)) { return memo.get(target); }
        if (target.isEmpty()) { return 1; }
        Integer sum = 0;
        for (String prefix : wordBank) {
            if (!target.startsWith(prefix)) { continue; }
            sum += dynamicCountConstructMemo(target.replaceFirst(prefix, ""), wordBank, memo);
        }
        memo.put(target, sum);
        return sum;
    }

    /**
     * HOW COUNT DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */
    public Integer dynamicCountConstructTabular(String target, List<String> wordBank) {
        List<Integer> tabulation = new  ArrayList<>();
        tabulation.add(1);
        for (int i = 0; i < target.length(); i++) { tabulation.add(0); }

        for (int i = 0; i < target.length(); i++) {
            if (tabulation.get(i) == 0) { continue; }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (word.startsWith(prefix)) {
                    tabulation.set(
                        i+prefix.length(),
                        tabulation.get(i) + tabulation.get(i+prefix.length())
                    );
                }
            }
        }
        return tabulation.get(target.length());
    }

    /**
     * ===============================================================
     *                        ALL CONSTRUCTS  
     *                      optimization problem                    
     * ===============================================================
     */

    /**
     * ALL CONSTRUCTS NAIVE IMPLEMENTATION
     */
    public List<List<String>> naiveAllConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) { return Arrays.asList(new ArrayList<>()); }
        List<List<String>> result = new ArrayList<>();
        for (String prefix : wordBank) {
            if (target.startsWith(prefix)) {
                List<List<String>> sufixWays =  naiveAllConstruct(target.replaceFirst(prefix, ""), wordBank);
                sufixWays.forEach( a -> a.add(0, prefix));
                result.addAll(sufixWays);
            }
        }
        return result;
    }

    /**
     * ALL CONSTRUCTS DYNAMIC IMPLEMENTATION
     * USING MEMOIZATION
     */
    public List<List<String>> dynamicAllConstructMemo(String target, List<String> wordBank) {
        return dynamicAllConstructMemo(target, wordBank, new HashMap<>());
    }
    private List<List<String>> dynamicAllConstructMemo(String target, List<String> wordBank, HashMap<String, List<List<String>>> memo) {
        if (memo.containsKey(target)) { return memo.get(target); }
        if (target.isEmpty()) { return Arrays.asList(new ArrayList<>()); }
        List<List<String>> result = new ArrayList<>();
        for (String prefix : wordBank) {
            if (target.startsWith(prefix)) {
                List<List<String>> sufixWays = dynamicAllConstructMemo(target.replaceFirst(prefix, ""), wordBank, memo)
                    .stream()
                    .map( a -> new ArrayList<>(a))
                    .collect(Collectors.toList());
                sufixWays.forEach( a -> a.add(0, prefix));
                result.addAll(sufixWays);
            }
        }
        memo.put(target, result);
        return result;
    }

    /**
     * BEST SUM DYNAMIC IMPLEMENTATION
     * USING TABULATION
     */
    public List<List<String>> dynamicAllConstructTabular(String target, List<String> wordBank) {
        List<List<List<String>>> tabulation = new ArrayList<>();
        tabulation.add(new ArrayList<>());
        tabulation.get(0).add(new ArrayList<>());
        for (int i = 0; i < target.length(); i++) { tabulation.add(new ArrayList<>()); }

        for (int i = 0; i <= target.length(); i++) {
            if (tabulation.get(i).isEmpty()) { continue; }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (!word.startsWith(prefix)) { continue; }
                List<List<String>> current = tabulation.get(i)
                    .stream()
                    .map(a -> new ArrayList<>(a))
                    .collect(Collectors.toList());
                current.forEach(arr -> arr.add(prefix));
                tabulation.get(i+prefix.length()).addAll(current);
            }
        }
        return tabulation.get(target.length());
    }
    
}
