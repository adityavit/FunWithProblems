package linkedList.removeDuplicates;

import linkedList.common.Node;
import linkedList.common.Utils;

/**
 * Created by adib on 6/4/16.
 */
public class TestCaseRunner {

    public static void main(String[] args) {
        Solution sol = new Solution();

        //Test Case 1
        int[] duplicatelistArray = {1, 1, 1, 2, 3, 2 ,2};
        int[] nonDuplicateListArray = {1, 2 , 3};
        Node head = Utils.createLinkedListFromArray(duplicatelistArray);
        Node nonDuplicateListHead = Utils.createLinkedListFromArray(nonDuplicateListArray);
        Utils.printList(head);
        Utils.printList(nonDuplicateListHead);
        sol.removeDuplicates(head);
        assert Utils.compareListValuesEqual(head, nonDuplicateListHead);

        //Test Case 2
        int[] duplicatelistArray2 = {};
        int[] nonDuplicateListArray2 = {};
        head = Utils.createLinkedListFromArray(duplicatelistArray2);
        nonDuplicateListHead = Utils.createLinkedListFromArray(nonDuplicateListArray2);
        Utils.printList(head);
        Utils.printList(nonDuplicateListHead);
        sol.removeDuplicates(head);
        assert Utils.compareListValuesEqual(head, nonDuplicateListHead);
    }
}
