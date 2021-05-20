package week1;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i];
        }

        int p = 1;
        for (int k = nums.length - 1; k > 0; k--) {
            result[k] = result[k - 1] * p;
            p *= nums[k];

        }
        result[0] = p;
        return result;
    }
}
