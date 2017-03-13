package linkedList.partitionList;

import linkedList.common.Node;
import linkedList.common.Utils;

/**
 * Created by adib on 6/4/16.
 */
public class TestCaseRunner {

    public static void main(String[] args) {
        Solution sol = new Solution();

        //Test Case 1
        int[] listArray = {1, 2, 1, 3, 3, 6, 5, 8, 7, 6};
        Node head = Utils.createLinkedListFromArray(listArray);
        Node partitionHead = sol.partition(head, 5);
        Utils.printList(partitionHead);

        //Test Case 2
        int[] listArray2 = {3, 6, 5, 8, 7, 6,1, 2, 1, 3, 3};
        Node head2 = Utils.createLinkedListFromArray(listArray2);
        Node partitionHead2 = sol.partition(head2, 3);
        Utils.printList(partitionHead2);
    }
}
