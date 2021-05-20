package week2;

public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while(i <= j) {
            int mid = (i + j) /2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (target >= nums[i] || nums[mid] < nums[i]) {  //left
                    j = mid - 1;
                } else {
                    i = mid + 1;  //right
                }
            } else if (nums[mid] < target) { //
                if (target <= nums[j] || nums[mid] > nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }

        return -1;
    }

    public int searchUsingPivot(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int pivot = findPivot(nums);
        System.out.println("pivot=" + pivot);
        if (target >= nums[pivot] && target <= nums[r]) {
            l = pivot;
        } else {
            r = pivot - 1;
        }


        while(l <= r) {
            int mid = (l + r)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }


    private int findPivot(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while( l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
