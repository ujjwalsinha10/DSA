package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Input:
 * n = 10,m = 7.
 * arr1[] = {1,2,3,4,5,6,7,8,9,10}
 * arr2[] = {2,3,4,4,5,11,12}
 * Output: {1,2,3,4,5,6,7,8,9,10,11,12}
 * 
 */

public class UnionTwoSortedArrays {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };
        int n1 = arr1.length;
        int n2 = arr2.length;

        unionArray(arr1, arr2, n1, n2);
    }

    private static void unionArray(int[] arr1, int[] arr2, int n1, int n2) {
        int i = 0;
        int j = 0;
        List<Integer> unionArr = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (!unionArr.contains(arr1[i])) {
                    unionArr.add(arr1[i]);
                }
                i++;
            } else {
                if (!unionArr.contains(arr2[j])) {
                    unionArr.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (!unionArr.contains(arr1[i])) {
                unionArr.add(arr1[i]);
            }
            i++;
        }
        while (j < n2) {
            if (!unionArr.contains(arr2[j])) {
                unionArr.add(arr2[j]);
            }
            j++;
        }
        System.out.println(unionArr.toString());
    }

}
