package Search;

/*
 * Input Format: n = 8, arr[] = {2, 4, 6, 8, 8, 8, 11, 13}, k = 8
 * Result: 3 5
 */
public class FirstAndLastOccurInArray {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 8, 8, 11, 13 };
        int n = arr.length;
        int k = 8;

        int[] result = getByLowerUpperBound(arr, n, k);
        System.out.println(result[0] + "," + result[1]);

        int[] result2=getUsingSimpleBinarySearch(arr, n, k);
        System.out.println(result2[0] + "," + result2[1]);
    }

    // TC: 2*O(logN) SC:O(1)
    private static int[] getByLowerUpperBound(int[] arr, int n, int k) {
        int lb = getLowerBound(arr, n, k);
        if (lb == n || arr[lb] != k) {
            return new int[] { -1, -1 };
        }
        int ub = getUpperBound(arr, n, k);
        return new int[] { lb, ub - 1 };

    }

    private static int getLowerBound(int[] arr, int n, int k) {
        int start = 0;
        int end = n - 1;
        int ans = n;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int getUpperBound(int[] arr, int n, int k) {
        int start = 0;
        int end = n - 1;
        int ans = n;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int[] getUsingSimpleBinarySearch(int[] arr, int n, int k) {
        // check for the left index
        int low = 0;
        int high = n - 1;
        int leftIndex = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                leftIndex = mid;
                high=mid-1;
            }else if(arr[mid]<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        //if there is no first occurrence, no need to check further
        if(leftIndex==-1){
            return new int[] {-1,-1};
        }

        // check for the right index -> so,making low & high to default value
        int rightindex=-1;
        low=0;
        high=n-1;
        while(low<=high){
            int mid1=(high+low)/2;
            if(arr[mid1]==k){
                rightindex=mid1;
                low=mid1+1;
            }else if(arr[mid1]<k){
                low=mid1+1;
            }else{
                high=mid1-1;
            }

        }
        return new int[] { leftIndex, rightindex};
    }
}
