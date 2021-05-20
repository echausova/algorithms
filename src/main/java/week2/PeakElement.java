package week2;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r-l)/2;
            System.out.println("l=" + l + ", r=" + r + ", mid=" + mid);
            if (nums[mid] < nums[mid + 1]){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
