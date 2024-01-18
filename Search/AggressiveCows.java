package Search;

import java.util.Arrays;

/*
 * Input Format: N = 6, k = 4, arr[] = {0,3,4,7,10,9}
 * Result: 3
 * Explanation: The maximum possible minimum distance between any two cows will be 
 * 3 when 4 cows are placed at positions {0, 3, 7, 10}. 
 * Here the distances between cows are 3, 4, and 3 respectively. 
 * We cannot make the minimum distance greater than 3 in any ways.
 */

public class AggressiveCows {
    public static void main(String[] args) {

        int stalls[] = { 0, 3, 4, 7, 10, 9 };
        int k = 4;
        System.out.println(bruteForce(stalls, k));
        System.out.println(usingBinarySearch(stalls, k));
    }

    // TC: O(NlogN) + O(N * log(max(stalls[])-min(stalls[]))),
    // where N = size of the array, max(stalls[]) = maximum element in stalls[]
    // array, min(stalls[]) = minimum element in stalls[] array.
    // SC: O(1)
    private static int usingBinarySearch(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, k, mid) == true) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    // TC: O(NlogN) + O(N *(max(stalls[])-min(stalls[]))),
    // where N = size of the array, max(stalls[]) = maximum element in stalls[]
    // array, min(stalls[]) = minimum element in stalls[] array.
    // SC: O(1)
    private static int bruteForce(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int limit = stalls[n - 1] - stalls[0];
        for (int i = 0; i <= limit; i++) {
            if (canWePlace(stalls, k, i) == false) {
                return (i - 1);
            }
        }
        return limit;
    }

    private static boolean canWePlace(int[] stalls, int cows, int dist) {
        int n = stalls.length;
        int cntcows = 1; //no. of cows placed
        int last = stalls[0]; //position of last placed cow.
        for (int i = 0; i < n; i++) {
            if ((stalls[i] - last) >= dist) {
                cntcows++; //place next cow.
                last = stalls[i]; //update the last location.
            }
            if (cntcows >= cows)
                return true;
        }
        return false;

    }

}
