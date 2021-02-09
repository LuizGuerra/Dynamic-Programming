import java.util.HashMap;
import java.util.List;

/*
    Verify if is possible to target word be constructed by concatenating elements of the string array.
*/

public class CanConstruct {

    public CanConstruct() { }
    
    public boolean naiveConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) { return true; }
        for (String subWord : wordBank) {
            if (target.length() < subWord.length()) { continue; }
            if (!target.startsWith(subWord)) { continue; }
            if (naiveConstruct(target.replaceFirst(subWord, ""), wordBank)) {
                return true;
            } 
        }
        return false;
    }
    
    public boolean dynamicConstruct(String target, List<String> wordBank) {
        return dynamicConstruct(target, wordBank, new HashMap<>());
    }

    private boolean dynamicConstruct(String target, List<String> wordBank, HashMap<String, Boolean> memo) {
        if (memo.containsKey(target)) { return memo.get(target); }
        if (target.isEmpty()) { return true; }
        for (String subWord : wordBank) {
            if (target.length() < subWord.length()) { continue; }
            if (!target.startsWith(subWord)) { continue; }
            if (dynamicConstruct(target.replaceFirst(subWord, ""), wordBank, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }
    
    
}
