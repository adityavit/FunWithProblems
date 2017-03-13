package linkedList.kthLastElement;

import linkedList.common.Node;
import linkedList.common.Utils;

/**
 * Created by adib on 6/4/16.
 */
public class TestCaseRunner {

    public static void main(String[] args){
        Solution sol = new Solution();

        // Test Case 1
        int[] listArray = {1, 2, 3, 4, 5, 6, 7};
        Node head = Utils.createLinkedListFromArray(listArray);
        Node kthLastNode = sol.findkthLastElement(head, 3);
        assert kthLastNode.getData() == 5;


        //Test Case 2
        kthLastNode = sol.findkthLastElement(head, 1);
        assert kthLastNode.getData() == 7;

        //Test Case 3
        kthLastNode = sol.findkthLastElement(head, 7);
        assert kthLastNode.getData() == 1;

        //Test Case 4
        kthLastNode = sol.findkthLastElement(head, 8);
        assert kthLastNode == null;
    }

}
