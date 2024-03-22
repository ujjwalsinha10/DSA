package RecursionAdvanced;

import java.util.ArrayList;
import java.util.List;

public class AnyOneSubsequenceOfSum {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        int n = arr.length;
        int sum = 2;
        List<Integer> al = new ArrayList<>();
        printSubseq(0, arr, sum, n, 0, al);
    }

    private static boolean printSubseq(int i, int[] arr, int sum, int n, int s, List<Integer> al) {
        if (i == n) {
            if (s == sum) {
                System.out.println(al.toString());
                return true;
            } else
                return false;
        }
        al.add(arr[i]);
        s += arr[i];
        if (printSubseq(i + 1, arr, sum, n, s, al) == true) {
            return true;
        }
        s -= arr[i];
        al.remove(al.size()-1);
        if(printSubseq(i + 1, arr, sum, n, s, al)==true){
            return true;
        }
        return false;
    }
}
