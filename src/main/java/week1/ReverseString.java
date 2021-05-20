package week1;

public class ReverseString {

    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        s = s.trim();
        char[] arr = s.toCharArray();

        reverse(arr, 0, s.length() - 1); //reverse the whole string

        StringBuilder result = new StringBuilder();
        int begin = 0;
        for (int i = 0; i <= arr.length; i++) {
            if (i == arr.length || arr[i] == ' ' && begin != i) {
                reverse(arr, begin, i - 1);  //reverse a word
                result.append(arr, begin, i - begin);
                if (i != arr.length) {
                    result.append(" ");
                }
                begin = i + 1;
            } else if (arr[i] == ' ' && begin == i) {
                begin++; //skip spaces
            }
        }

        return result.toString();
    }

    private static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

    private static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}