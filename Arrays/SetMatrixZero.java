package Arrays;

/*
 * Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 */
public class SetMatrixZero {
    public static void main(String[] args) {
        int input[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int[][] bruteForceApproach = bruteForceApproach(input);
        for (int i = 0; i < bruteForceApproach.length; i++)
            // Loop through all elements of current row
            for (int j = 0; j < bruteForceApproach[i].length; j++)
                System.out.print(bruteForceApproach[i][j] + " ");

        System.out.println();
        int[][] betterApproach = betterApproach(input);
        for (int i = 0; i < betterApproach.length; i++)
            // Loop through all elements of current row
            for (int j = 0; j < betterApproach[i].length; j++)
                System.out.print(betterApproach[i][j] + " ");
    }

    // TC: O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in
    // the matrix.
    // SC: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns
    // in the matrix.
    private static int[][] betterApproach(int[][] input) {
        int row = input.length;
        int col = input[0].length;
        int[] r = new int[row];
        int[] c = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (input[i][j] == 0) {
                    r[i] = 1;
                    c[j] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (r[i] == 1 || c[j] == 1) {
                    input[i][j] = 0;
                }
            }
        }
        return input;
    }

    // TC: O((N*M)*(N + M)) + O(N*M), where N = no. of rows in the matrix and M =
    // no. of
    // columns in the matrix.
    // SC:O(1)
    private static int[][] bruteForceApproach(int[][] input) {
        int c = input[0].length;
        int r = input.length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (input[i][j] == 0) {
                    markRow(input, r, c, i);
                    markCol(input, r, c, j);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (input[i][j] == -1) {
                    input[i][j] = 0;
                }
            }
        }
        return input;
    }

    private static void markCol(int[][] input, int r, int c, int j) {
        for (int x = 0; x < c; x++) {
            if (input[x][j] != 0) {
                input[x][j] = -1;
            }
        }
    }

    private static void markRow(int[][] input, int r, int c, int i) {
        for (int x = 0; x < c; x++) {
            if (input[i][x] != 0) {
                input[i][x] = -1;
            }
        }
    }
}
