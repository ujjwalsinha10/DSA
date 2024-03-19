package SlidingWindow_TwoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthLongestSubStrWORep {
    public static void main(String[] args) {
        String str="abcabcbb";
        int result = bruteforceApproach(str);
        System.out.println(result);
        int result1=optimizedApproach(str);
        System.out.println(result1);
    }

    // TC:O(N)  SC:O(N)
    private static int optimizedApproach(String str) {
        Map<Character, Integer> mpp= new HashMap<>();
        int left=0;
        int right=0;
        int n= str.length();
        int len=0;
        while(right<n){
            if(mpp.containsKey(str.charAt(right)))
            left=Math.max(mpp.get(str.charAt(right))+1, left);

            mpp.put(str.charAt(right),right);
            len=Math.max(len, right-left+1);
            right++;
        }
        return len;
    }

    // TC: O(N^2)  SC: O(N)
    private static int bruteforceApproach(String str) {
        if(str.length()==0)
            return 0;
        int maxAns=Integer.MIN_VALUE;
        for(int i=0;i<str.length();i++){
            Set<Character> set= new HashSet<>();
            for(int j=i;j<str.length();j++){
                if(set.contains(str.charAt(j))){
                    maxAns=Math.max(maxAns, j-i);
                    break;
                }
                set.add(str.charAt(j));
            }
        }
        return maxAns;
    }
}
