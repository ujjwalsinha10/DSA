package Search;

/*
 * Input Format: N = 4, a[] = {7, 15, 6, 3}, h = 8
 * Result: 5
 * Explanation: If Koko eats 5 bananas/hr, he will take 2, 3, 2, 
 * and 1 hour to eat the piles accordingly. So, he will take 8 hours to 
 * complete all the piles.  
 */

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] v = { 7, 15, 6, 3 };
        int h = 8;

        System.out.println(findMinRateToEatBananas(v, h));
    }

    // TC: O(N * log(max(a[]))), where max(a[]) is the maximum element in the array 
    // and N = size of the array.
    // SC: O(1)
    private static int findMinRateToEatBananas(int[] v, int h) {
        int low = 1;
        int high = findMax(v);
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateHours(v, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int calculateHours(int[] v, int hourly) {
        int total = 0;
        for (int i = 0; i < v.length; i++) {
            total += Math.ceil((double) v[i] / (double) hourly);
        }
        return total;
    }

    private static int findMax(int[] v) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < v.length; i++) {
            max = Math.max(max, v[i]);
        }
        return max;
    }
}
