package linkedList.common;

/**
 * Created by adib on 6/4/16.
 */
public class Utils {

    public static Node createLinkedListFromArray(int[] elems) {
        Node head = null;
        if (elems.length > 0) {
            head = new Node(elems[0]);
        }
        Node pointer = head;
        for(int i = 1; i<elems.length; i++) {
            Node nodeElem = new Node(elems[i]);
            pointer.next = nodeElem;
            pointer = pointer.next;
        }
        return head;
    }

    public static boolean compareListValuesEqual(Node list1, Node list2) {
        if (list1 == null && list2 == null) {
            return true;
        }
        Node nextPtr1 = list1;
        Node nextPtr2 = list2;
        //Check the data in both the list.
        while(nextPtr1 != null && nextPtr2 != null) {
            if(nextPtr1.data != nextPtr2.data) {
                return false;
            }
            nextPtr1 = nextPtr1.next;
            nextPtr2 = nextPtr2.next;
        }
        // If the two lists are of unequal size return false
        if(nextPtr1 != null || nextPtr2 != null) {
            return false;
        }
        return true;
    }

    public static void printList(Node head){
        if (head == null) {
            System.out.println("NULL");
        }
        Node nextPtr = head;
        while(nextPtr != null) {
            if(nextPtr.next != null){
                System.out.print(nextPtr + "-->");
            } else {
                System.out.println(nextPtr + "-->NULL");
            }
            nextPtr = nextPtr.next;
        }
    }
}
