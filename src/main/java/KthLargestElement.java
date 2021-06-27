public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        return quickSelect(nums, n - k, 0, n);
    }

    private int quickSelect(int[] nums, int k, int i, int j) {
        if (i >= j) {
            return nums[i];
        }

        int p = i;

        int pos = partition(nums, p, i + 1, j);

        if (pos == k) {
            return nums[pos];
        } else if (pos < k) {
            return quickSelect(nums, k, pos + 1, j);
        } else {
            return quickSelect(nums, k, i, pos);
        }
    }

    private int partition(int[] nums, int p, int i, int j) {
        int pos = p;
        for (int k = i; k < j; k++) {
            if (nums[k] <= nums[p]) {
                pos++;
                int t = nums[k];
                nums[k] = nums[pos];
                nums[pos] = t;
            }
        }

        int t = nums[p];
        nums[p] = nums[pos];
        nums[pos] = t;

        return pos;
    }
}
