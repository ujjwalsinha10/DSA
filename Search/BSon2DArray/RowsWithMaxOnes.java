package Search.BSon2DArray;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Input Format: n = 3, m = 3, 
    mat[] = 
    1 1 1
    0 0 1
    0 0 0
    Result: 0
 */
public class RowsWithMaxOnes {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix= new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,1,1)));
        matrix.add(new ArrayList<>(Arrays.asList(0,0,1)));
        matrix.add(new ArrayList<>(Arrays.asList(0,0,0)));

        int rows=3; int columns=3;
        System.out.println(getByBruteForce(matrix, rows,columns));
        System.out.println(getByLowerBound(matrix, rows, columns));
    }

    // TC: O(n X logm), where n = given row number, m = given column number.
    // SC: O(1)
    private static int getByLowerBound(ArrayList<ArrayList<Integer>> matrix, int rows, int columns) {
        int cnt_Max=0;
        int index=-1;
        for(int i=0;i<rows;i++){
            int cnt_Ones=columns-lowerBound(matrix.get(i),columns,1);
            if(cnt_Ones>cnt_Max){
                cnt_Max=cnt_Ones;
                index=i;
            }
        }
        return index;
    }

    private static int lowerBound(ArrayList<Integer> arr, int columns, int i) {
        int low=0;
        int high=columns-1;
        int ans=i;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr.get(mid)>=i){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    // TC: O(n X m), where n = given row number, m = given column number.
    // SC: O(1)
    private static int getByBruteForce(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int cnt_max=0;
        int index=-1;
        for(int i=0;i<n;i++){
            int cnt_Ones=0;
            for(int j=0;j<m;j++){
                cnt_Ones+=matrix.get(i).get(j);
            }

            if(cnt_Ones>cnt_max){
                cnt_max=cnt_Ones;
                index=i;
            }
        }
        return index;
    }
    
}
