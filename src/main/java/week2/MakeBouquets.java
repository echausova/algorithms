package week2;

public class MakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay == null || bloomDay.length == 0) {
            return -1;
        }

        if (m * k > bloomDay.length) {
            return -1;
        }

        int maxDay = findMax(bloomDay);
        int minDay = -1;

        int l = 1;
        int r = maxDay;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (canMakeBouquet(bloomDay, m, k, mid)) {
                minDay = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return minDay;
    }

    private boolean canMakeBouquet(int[] bloomDay, int m, int k, int d) {
        int bouquetCount = 0;
        int flowerCnt = 0;
        for (int day : bloomDay) {
            if (bouquetCount == m) {
                return true;
            }
            if (day <= d) {
                flowerCnt++;
                if (flowerCnt == k) {
                    bouquetCount++;
                    flowerCnt = 0;
                }
            } else {
                flowerCnt = 0;
            }
        }

        return bouquetCount == m;
    }

    private int findMax(int[] bloomDay) {
        int max = bloomDay[0];
        for (int i = 1; i < bloomDay.length; i++) {
            max = Math.max(max, bloomDay[i]);
        }
        return max;
    }
}
