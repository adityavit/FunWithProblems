package binarySearch;

/**
 * Created by adib on 8/22/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //Test Case 1
        int[] arr = {1};
        assert sol.binarySearch(arr, 1) == 0;

        //Test case 2
        int[] arr1 = {};
        assert sol.binarySearch(arr1, 1) == -1;

        //Test case 3
        int[] arr2 = {1, 2 , 3 ,4 ,5};
        assert sol.binarySearch(arr2, 0) == -1;

        //Test case 4
        int[] arr3 = {2, 2, 2, 2, 2};
        assert sol.binarySearch(arr3, 2) == 2;

        //Test case 5
        int[] arr4 = {1, 3, 5, 7, 9, 12};
        assert sol.binarySearch(arr4, 12) == 5;

        System.out.println(Math.sqrt(182));
        System.out.println(182/14);
    }
}
