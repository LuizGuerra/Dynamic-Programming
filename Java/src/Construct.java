import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    Verify if is possible to target word be constructed by concatenating elements of the string array.
*/

public class Construct {

    public Construct() { }
    
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
    
    public int naiveCountConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) { return 1; }
        int sum = 0;
        for (String prefix : wordBank) {
            if (!target.startsWith(prefix)) { continue; }
            sum += naiveCountConstruct(target.replaceFirst(prefix, ""), wordBank);
        }
        return sum;
    }

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

    public List<List<String>> dynamicAllConstructMemo(String target, List<String> wordBank) {
        return dynamicAllConstructMemo(target, wordBank, new HashMap<>());
    }

    private List<List<String>> dynamicAllConstructMemo(String target, List<String> wordBank, HashMap<String, List<List<String>>> memo) {
        if (memo.containsKey(target)) { return memo.get(target); }
        if (target.isEmpty()) { return Arrays.asList(new ArrayList<>()); }
        List<List<String>> result = new ArrayList<>();
        for (String prefix : wordBank) {
            if (target.startsWith(prefix)) {
                List<List<String>> sufixWays =  dynamicAllConstructMemo(target.replaceFirst(prefix, ""), wordBank, memo);
                sufixWays.forEach( a -> a.add(0, prefix));
                result.addAll(sufixWays);
            }
        }
        memo.put(target, result);
        return result;
    }
    
}
