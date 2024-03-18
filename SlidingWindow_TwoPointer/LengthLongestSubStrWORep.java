package SlidingWindow_TwoPointer;

import java.util.HashSet;
import java.util.Set;

public class LengthLongestSubStrWORep {
    public static void main(String[] args) {
        String str="abcabcbb";
        int result = bruteforceApproach(str);
        System.out.println(result);
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
