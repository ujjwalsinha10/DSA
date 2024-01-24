package Search.BSon2DArray;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Input Format: N = 3, M = 4, target = 8,
    mat[] = 
    1 2 3 4
    5 6 7 8 
    9 10 11 12
    Result: true
 */
public class SearchIn2DMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>matrix= new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,2,3,4)));
        matrix.add(new ArrayList<>(Arrays.asList(5,6,7,8)));
        matrix.add(new ArrayList<>(Arrays.asList(9,10,11,12)));
        int rows=3; int columns=4;
        int target=8;

        System.out.println(getByOptimalApproach(matrix, rows, columns, target));
        System.out.println(getByBetterApproach(matrix, rows, columns, target));
    }

    // TC: O(N + logM), where N = given row number, M = given column number.
    // SC: O(1)
    private static boolean getByBetterApproach(ArrayList<ArrayList<Integer>> matrix, int rows, int columns, int target) {
        int n=matrix.size();
        int m=matrix.get(0).size();
        for(int i=0;i<n;i++){
            if(matrix.get(i).get(0)<=target && target<=matrix.get(i).get(m-1)){
                return binarySearch(matrix.get(i), target);
            }
        }
        return false;
    }

    private static boolean binarySearch(ArrayList<Integer> arrayList, int target) {
        int n=arrayList.size();
        int low=0; int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arrayList.get(mid)==target){
                return true;
            }else if(arrayList.get(mid)<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }

    // TC: O(log(NxM)), where N = given row number, M = given column number.
    // SC: O(1)
    private static boolean getByOptimalApproach(ArrayList<ArrayList<Integer>> matrix, int rows, int columns, int target) {
        int n=matrix.size();
        int m=matrix.get(0).size();
        int low=0;int high=(n*m)-1;
        while(low<=high){
            int mid=(low+high)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix.get(row).get(col)==target){
                return true;
            }else if(matrix.get(row).get(col)<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}
