package Search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Input Format: n = 5, m = 4, arr[] = {25, 46, 28, 49, 24}
 * Result: 71
 * Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24.
 */

public class BookAllocation {
    public static void main(String[] args) {
        List<Integer> books = Arrays.asList(25, 46, 28, 49, 24);
        int noOfStudents = 4;

        System.out.println(findByBruteForce(books, noOfStudents));
        System.out.println(findByBinarySearch(books, noOfStudents));
    }

    // TC: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array,
    // sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array
    // elements.
    // SC: O(1)
    private static int findByBinarySearch(List<Integer> books, int noOfStudents) {
        int n = books.size();
        if (n < noOfStudents)
            return -1;
        int low = Collections.max(books);
        int high = books.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(books, mid);
            if (students > noOfStudents) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // TC: O(N * (sum(arr[])-max(arr[])+1)), where N = size of the array,
    // sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array
    // elements.
    // SC:O(1)
    private static int findByBruteForce(List<Integer> books, int noOfStudents) {
        int n = books.size();
        if (n < noOfStudents)
            return -1;
        int low = Collections.max(books);
        int high = books.stream().mapToInt(Integer::intValue).sum();
        for (int pages = low; pages <= high; pages++) {
            if (countStudents(books, pages) == noOfStudents) {
                return pages;
            }
        }
        return low;
    }

    private static int countStudents(List<Integer> books, int pages) {

        int n = books.size();
        int students = 1;
        int pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + books.get(i) <= pages) {
                pagesStudent += books.get(i);
            } else {
                students++;
                pagesStudent += books.get(i);
            }
        }
        return students;
    }
}
