package airbnb;

/**
 * Implement a Queue class which as two methods enqueue and dequeue,
 * though internally it uses an array of maximum 5 elems to store the object.
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        QueueMax queue = new QueueMax();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

class LinkedList {
    private static int MAX_ELEM_SIZE = 5;

    class Node {
        Object[] elems;
        int elemSize;
        int counter;
        Node next;
        public Node() {
            elems = new Object[5];
            next = null;
            elemSize = 0;
            counter = 0;
        }
    }
    Node header;
    Node current;
    public LinkedList() {
        header = new Node();
        current = header;
    }

    boolean full() {
        if (current.elemSize == MAX_ELEM_SIZE) {
            return true;
        }
        return false;
    }

    void addNewNode() {
        Node temp = new Node();
        current.next = temp;
        current = temp;
    }

    void add(Object elem) {
        if (full()) {
            addNewNode();
        }
        current.elems[current.elemSize] = elem;
        current.elemSize++;
    }

    public boolean empty() {
        if (header == null || (header == current && header.counter == header.elemSize)) {
            return true;
        }
        return false;
    }

    public Object removeFirst() throws Exception {
        if (empty()) {
            throw new Exception("List is empty");
        }
        if (header.counter == MAX_ELEM_SIZE) {
            Node temp = header;
            header = header.next;
            temp.next = null;
        }
        Object retVal = header.elems[header.counter];
        header.counter++;
        return retVal;
    }


}

class QueueMax {

    LinkedList list;
    public QueueMax() {
        list = new LinkedList();
    }
    public void enqueue(Object elem) {
        list.add(elem);
    }

    public Object dequeue() throws Exception{
        return list.removeFirst();
    }
}
