package linkedList.sumList;

import linkedList.common.Node;
import linkedList.common.Utils;

/**
 * Created by adib on 6/5/16.
 */
public class TestCaseRunner {

    public static void main(String[] args) {
        Solution sol = new Solution();

        //Test Case 1
        int[] list1Arr = {4, 2, 9, 9};
        int[] list2Arr = {6, 8};
        int[] resultArr = {0, 1, 0 , 0, 1};
        Node list1 = Utils.createLinkedListFromArray(list1Arr);
        Node list2 = Utils.createLinkedListFromArray(list2Arr);

        Node result = sol.sumListReverse(list1, list2);
        Utils.printList(result);

        //Test Case 2
        int[] list3Arr = {9, 7, 8};
        int[] list4Arr = {6, 8, 5};
        Node list3 = Utils.createLinkedListFromArray(list3Arr);
        Node list4 = Utils.createLinkedListFromArray(list4Arr);

        Node result2 = sol.sumListReverse(list3, list4);
        Utils.printList(result2);


        //Forward list
        //Test Case 1
        int[] listArr1 = {4, 5, 2, 8, 9};
        int[] listArr2 = {6, 7};
        Node listForward1 = Utils.createLinkedListFromArray(listArr1);
        Node listForward2 = Utils.createLinkedListFromArray(listArr2);

        Node resultForward = sol.sumListForward(listForward1, listForward2);
        Utils.printList(resultForward);

        //Test Case 2
        int[] listArr3 = {4};
        int[] listArr4 = {6, 7};
        Node listForward3 = Utils.createLinkedListFromArray(listArr3);
        Node listForward4 = Utils.createLinkedListFromArray(listArr4);

        Node resultForward2 = sol.sumListForward(listForward3, listForward4);
        Utils.printList(resultForward2);
    }
}
