package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Input format: Arr[] = {1,3,2}
 * Output: Arr[] = {2,1,3}
 */
public class NextPermutation {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[] { 2, 1, 5, 4, 3, 0, 0 });
        int n = list.size();
        System.out.println(findNextPerm(list, n).toString());
    }

    private static List<Integer> findNextPerm(List<Integer> list, int n) {
        // Step 1: Find the break point:
        int index = -1;// break point
        for (int i = n - 2; i >= 0; i--) {
            if (list.get(i) < list.get(i + 1)) {
                // index i is the break point
                index = i;
                break;
            }
        }
        // If break point does not exist:
        if (index == -1) {
            // reverse the whole array:
            Collections.reverse(list);
            return list;
        }
        // Step 2: Find the next greater element
        // and swap it with arr[ind]:
        for (int i = n - 1; i > index; i--) {
            if (list.get(i) > list.get(index)) {
                int temp = list.get(i);
                list.set(i, list.get(index));
                list.set(index, temp);
                break;
            }
        }
        // Step 3: reverse the right half:
        List<Integer> subList = list.subList(index + 1, n);
        Collections.reverse(subList);
        return list;
    }
}
