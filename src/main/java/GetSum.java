public class GetSum {
    public static int getSum(int a, int b) {
        int carry = 0;
        int res = 0;

        for (int k = 0; k < 32; k++) {
            int q1 = (a & 1);
            int q2 = (b & 1);

            int bit = q1 ^ q2 ^ carry;
            carry = q1 & q2 | carry & (q1 | q2);

            res |= bit << k;

            a >>= 1;
            b >>= 1;
        }

        return res;
    }
}

