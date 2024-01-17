package Search;

/*
 * Input Format: N = 5, weights[] = {5,4,5,2,3,4,5,6}, d = 5
 * Result: 9
 */

public class ShipMinCapacityToPackage {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;

        System.out.println(getMinCapacity(arr, days));
    }

    // TC: O(N * log(sum(weights[]) – max(weights[]) + 1)), where sum(weights[]) =
    // summation of all the weights, max(weights[]) = maximum of all the weights, N
    // = size of the weights array.
    // SC: O(1)
    private static int getMinCapacity(int[] arr, int days) {
        int n = arr.length;
        int maxWeight = 0;
        int minWeight = 0;
        for (int i = 0; i < n; i++) {
            minWeight = Math.max(minWeight, arr[i]);
            maxWeight += arr[i];
        }
        // System.out.println(minWeight+","+maxWeight);
        int low = minWeight;
        int high = maxWeight;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (getLoad(arr, mid) <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int getLoad(int[] arr, int mid) {
        int n = arr.length;
        int weight = 0;
        int days = 1;
        for (int i = 0; i < n; i++) {
            if (weight + arr[i] <= mid) {
                weight += arr[i];
            } else {
                weight = arr[i];
                days += 1;
            }
        }
        return days;
    }
}
