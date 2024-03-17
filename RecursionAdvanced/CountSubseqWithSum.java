package RecursionAdvanced;

public class CountSubseqWithSum {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 1};
        int n = arr.length;
        int sum = 2;
        System.out.println(countSubseq(0, arr, n, sum, 0));
    }

    private static int countSubseq(int i, int[] arr, int n, int sum, int s) {
        // done  iff array contains positive only
        if(s>sum) return 0;
        if (i == n) {
            if (s == sum) {
                return 1;
            } else
                return 0;
        }
        s += arr[i];
        int l = countSubseq(i + 1, arr, n, sum, s);
        s -= arr[i];
        int r = countSubseq(i + 1, arr, n, sum, s);
        return l + r;
    }
}
