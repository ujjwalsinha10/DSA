package Hashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HighLowFreq {
    public static void main(String[] args) {
        int array[] = {10,5,10,15,10,5};
        findHighLowFreq(array);

    }

    private static void findHighLowFreq(int[] array) {
        int n=array.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mpp.containsKey(array[i])) {
                mpp.put(array[i],mpp.get(array[i])+1);
            } else {
                mpp.put(array[i], 1);
            }

        }

        int max = mpp.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(0);
        int min = mpp.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(0);
        System.out.println(max+" "+min);
        
    }
    
}
