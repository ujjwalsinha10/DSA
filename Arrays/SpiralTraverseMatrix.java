package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Input: Matrix[][] = { { 1, 2, 3, 4 },
		                 { 5, 6, 7, 8 },
		                 { 9, 10, 11, 12 },
	                     { 13, 14, 15, 16 } 
                        }
    Output: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
 */
public class SpiralTraverseMatrix {
    public static void main(String[] args) {
        int Matrix[][] = { { 1, 2, 3, 4 },
		                 { 5, 6, 7, 8 },
		                 { 9, 10, 11, 12 },
	                     { 13, 14, 15, 16 } 
                        };

        List<Integer> printSpiral = printSpiral(Matrix);
        System.out.print(printSpiral.toString());
    }

    // TC: O(N*M) SC: O(N)
    private static List<Integer> printSpiral(int[][] matrix) {
        int row=matrix.length;
        int col= matrix[0].length;
        int top=0;
        int right=col-1;
        int left=0;
        int bottom=row-1;
        List<Integer> list= new ArrayList<>();

        while(top<=bottom && left<=right){

            // Moving left to right
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;
            // Moving top to bottom
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;
            // Moving right to left
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // Moving bottom to top
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }    
}
