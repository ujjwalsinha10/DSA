package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Input Format: arr[] = {4,1,2,1,2}
 * Result: 4
 */
public class NumberAppearsOnce {
    public static void main(String[] args) {
        int arr[] = {4,1,2,1,2};
        int n=arr.length;

        System.out.print(solveByXor(arr,n));

        System.out.println(solveByMap(arr, n));
        
        
    }

    // TC: O(N*logM) + O(M), where M = size of the map i.e. M = (N/2)+1. N = size of the array.
    // SC: O((N/2)+1)
    private static int solveByMap(int[] arr, int n) {
        Map<Integer, Integer> hashMap= new HashMap<>();
        for(int i=0;i<n;i++){
            int freq=hashMap.getOrDefault(arr[i], 0);
            hashMap.put(arr[i],freq+1);
        }

        for(Map.Entry<Integer, Integer> map: hashMap.entrySet()){
            if(map.getValue()==1){
                return map.getKey();
            }
        }
        return -1;
    }

    // TC: O(n) SC: O(1)
    private static int solveByXor(int[] arr, int n) {
        int xor=0;
        for (int i = 0; i < n; i++) {
            xor=xor^arr[i];
        }
        return xor;
    }
    
}
