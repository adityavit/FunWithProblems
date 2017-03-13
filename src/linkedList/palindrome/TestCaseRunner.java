package linkedList.palindrome;

import linkedList.common.Node;
import linkedList.common.Utils;

/**
 * Created by adib on 6/5/16.
 */
public class TestCaseRunner {

    public static void main(String[] args) {
        Solution sol = new Solution();

        //Test Case 1: Odd number of list true
        int[] palindromeArr1 = {1, 2, 3, 2, 1};
        Node list1 = Utils.createLinkedListFromArray(palindromeArr1);
        System.out.println(sol.checkPalindrome(list1));

        //Test Case 2: Odd number of list false
        int[] palindromeArr2 = {1, 2, 3, 3, 1};
        Node list2 = Utils.createLinkedListFromArray(palindromeArr2);
        System.out.println(sol.checkPalindrome(list2));

        //Test Case 3: Even number of list true
        int[] palindromeArr3 = {1, 2, 3, 3, 2, 1};
        Node list3 = Utils.createLinkedListFromArray(palindromeArr3);
        System.out.println(sol.checkPalindrome(list3));

        //Test Case 4: Even number of list false
        int[] palindromeArr4 = {1, 2, 3, 3, 2, 4};
        Node list4 = Utils.createLinkedListFromArray(palindromeArr4);
        System.out.println(sol.checkPalindrome(list4));

        //Test Case 4: Empty list false
        int[] palindromeArr5 = {};
        Node list5 = Utils.createLinkedListFromArray(palindromeArr5);
        System.out.println(sol.checkPalindrome(list5));

        //Test Case 4: One list true
        int[] palindromeArr6 = {1};
        Node list6 = Utils.createLinkedListFromArray(palindromeArr6);
        System.out.println(sol.checkPalindrome(list6));

    }
}
