import java.util.ArrayList;
import java.util.List;

public class TargetSumComb {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        helper(candidates, target, result, sub, 0, 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> result,
                        List<Integer> sub, int curSum, int cur) {
        if (curSum == target) {
            result.add(List.copyOf(sub));
            return;
        }

        if (curSum > target) {
            return;
        }

        for (int i = cur; i < candidates.length; i++) {
            curSum += candidates[i];
            sub.add(candidates[i]);
            helper(candidates, target, result, sub, curSum, i);
            sub.remove(sub.size() - 1);
            curSum -= candidates[i];

        }
    }

}

