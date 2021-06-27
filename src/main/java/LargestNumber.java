import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        convert(arr, nums);
        CustomComparator comparator = new CustomComparator();
        Arrays.sort(arr, comparator);
        StringBuilder result = new StringBuilder();

        for (String str : arr) {
            result.append(str);
        }
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }

    private void convert(String[] arr, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            arr[i] = "" + nums[i];
        }
    }

    private class CustomComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            long first = Long.valueOf(s1 + s2);
            long second = Long.valueOf(s2 + s1);

            return Long.compare(second, first);
        }
    }
}