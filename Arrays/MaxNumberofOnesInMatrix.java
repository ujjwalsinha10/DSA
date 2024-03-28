package Arrays;

/*
 * Input Format: n = 3, m = 3, 
 * mat[] = 1 1 1
           0 0 1
           0 0 0
    Result: 0
 */
public class MaxNumberofOnesInMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
        System.out.println(countOnes(matrix));
    }

    // TC:O(n X logm), where n = given row number, m = given column number.
    // SC:O(1)
    private static int countOnes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count_max = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int count_ones = m - lowerBound(matrix[i], m, 1);
            if (count_ones > count_max) {
                count_max = count_ones;
                index = i;
            }
        }
        return index;
    }

    private static int lowerBound(int[] matrix, int m, int i) {
        int low = 0;
        int high = m - 1;
        int ans = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid] >= i) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
