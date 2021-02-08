import java.util.HashMap;
import java.util.List;

public class Sum {
    public Sum() {

    }

    public boolean naiveCanSum(int targetSum, List<Integer> numbers) {
        if (targetSum < 0) { return false; }
        if (targetSum == 0) { return true; }
        for (Integer value : numbers) {
            if (naiveCanSum(targetSum - value, numbers)) {
                return true;
            }
        }
        return false;
    }

    public boolean dynamicCanSum(int targetSum, List<Integer> numbers) {
        return dynamicCanSum(targetSum, numbers, new HashMap<>());
    }

    private boolean dynamicCanSum(int targetSum, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) { return memo.get(targetSum); }
        if (targetSum < 0) { return false; }
        if (targetSum == 0) { return true; }
        for (Integer value : numbers) {
            if (dynamicCanSum(targetSum - value, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }
}
