package week3;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        Stack<String> stack = new Stack<>();
        Stack<Integer> snum = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int res = Character.getNumericValue(c);
                i++;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    res = res * 10 + s.charAt(i);
                    i++;
                }
                i--;
                snum.push(res);
            } else if (c == ']') {
                StringBuilder str = new StringBuilder();
                str.append(stack.pop());

                int count = snum.pop();
                while(count > 0) {
                    str.append(result);
                    count--;
                }
                result = str;
            } else if (c == '[') {
                stack.push(result.toString());
                result = new StringBuilder();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
