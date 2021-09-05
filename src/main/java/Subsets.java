import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 1; i < Math.pow(2, nums.length); i++) {
            List<Integer> arr = new ArrayList<>();
            int n = i;
            for (int j = 0; j < nums.length; j++) {
                if ((n & 1) == 1) {
                    arr.add(nums[j]);
                }
                n >>= 1;
            }

            result.add(arr);
        }
        return result;
    }
}
