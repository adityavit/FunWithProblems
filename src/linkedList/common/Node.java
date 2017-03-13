package linkedList.common;

/**
 * Created by adib on 6/4/16.
 */
public class Node {
    int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }


    public int getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (data != node.data) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return data;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
