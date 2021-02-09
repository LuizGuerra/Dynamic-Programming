import java.util.ArrayList;
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

    public List<Integer> naiveHowSum(int targetSum, List<Integer> numbers) {
        if (targetSum < 0) { return null; }
        if (targetSum == 0) { return (new ArrayList<>()); }
        for (Integer value : numbers) {
            List<Integer> result = naiveHowSum(targetSum - value, numbers);
            if (result != null) {
                result.add(0, value);
                return result;
            }
        }
        return null;
    }

    public List<Integer> dynamicHowSum(int targetSum, List<Integer> numbers) {
        return dynamicHowSum(targetSum, numbers, new HashMap<>());
    }

    private List<Integer> dynamicHowSum(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) { return memo.get(targetSum); }
        if (targetSum < 0) { return null; }
        if (targetSum == 0) { return (new ArrayList<>()); }
        // System.out.println(memo);
        for (Integer value : numbers) {
            List<Integer> result = dynamicHowSum(targetSum - value, numbers, memo);
            if (result != null) {
                result.add(0, value);
                memo.put(targetSum, result);
                return result;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    public List<Integer> naiveBestSum(int targetSum, List<Integer> numbers) {
        if (targetSum < 0) { return null; }
        if (targetSum == 0) { return new ArrayList<>(); }
        List<Integer> shortest = null;
        for (Integer value : numbers)  {
            List<Integer> combination = naiveBestSum(targetSum - value, numbers);
            if (combination != null) {
                combination.add(0, value);
                if (shortest == null || shortest.size() > combination.size()) {
                    shortest = combination;
                }
            }
        }
        return shortest;
    }

    public List<Integer> dynamicBestSum(int targetSum, List<Integer> numbers) {
        return dynamicBestSum(targetSum, numbers, new HashMap<>());
    }
    // 8 - 1 4 5
    private List<Integer> dynamicBestSum(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) { return memo.get(targetSum); }
        if (targetSum < 0) { return null; }
        if (targetSum == 0) { return new ArrayList<>(); }
        List<Integer> shortest = null;
        for (Integer value : numbers)  {
            List<Integer> combination = dynamicBestSum(targetSum - value, numbers, memo);
            if (combination != null) {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                list.addAll(combination);
                if (shortest == null || shortest.size() > list.size()) {
                    shortest = list;
                }
            }
        }
        memo.put(targetSum, shortest);
        return shortest;
    }

}
