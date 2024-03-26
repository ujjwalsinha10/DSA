package Arrays;

/*
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 */
public class RotateMatrixByRightAngle {
    public static void main(String[] args) {
        int matrix[][]={{1,2,3},{4,5,6},{7,8,9}};
        int[][] bruteForceApproach = bruteForceApproach(matrix);
        for (int i = 0; i < bruteForceApproach.length; i++){
            // Loop through all elements of current row
            for (int j = 0; j < bruteForceApproach[i].length; j++)
                System.out.print(bruteForceApproach[i][j] + " ");
            System.out.println("\n");
        }

        System.out.println();

        optimalApproach(matrix);
        for (int i = 0; i < matrix.length; i++){
            // Loop through all elements of current row
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println("\n");
        }
    }

    private static void optimalApproach(int[][] matrix) {
        // Step1: transpose the matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // Step2: reverse the rows
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]=temp;
            }
        }
    }

    // TC:O(N*N)  SC:O(N*N)
    private static int[][] bruteForceApproach(int[][] matrix) {
        int rotated[][]= new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                rotated[j][matrix.length-i-1]=matrix[i][j];
            }
        }
        return rotated;
    }


}
