package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountFreq {
    public static void main(String[] args) {
        int arr[] = { 10, 5, 10, 15, 10, 5, 25 };
        countFreqEachElement(arr);
    }

    private static void countFreqEachElement(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mpp.containsKey(arr[i])) {
                mpp.put(arr[i],mpp.get(arr[i])+1);
            } else {
                mpp.put(arr[i], 1);
            }

        }

        //print
        System.out.println(mpp);

    }

}
