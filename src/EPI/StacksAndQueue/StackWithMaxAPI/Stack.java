package EPI.StacksAndQueue.StackWithMaxAPI;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by adib on 6/24/17.
 */
public class Stack<T extends Comparable<T>> {

    Deque<T> stack;
    Deque<T> maxElemStack;

    public Stack() {
        stack = new LinkedList<>();
        maxElemStack = new LinkedList<>();
    }

    public void push(T elem) {
        stack.push(elem);
        T maxElem = maxElemStack.peek();
        if(maxElem == null || elem.compareTo(maxElem) > 0 || elem.compareTo(maxElem) == 0) {
            maxElemStack.push(elem);
        }
    }

    public T pop() {
        T returnElem = stack.pop();
        T maxElem = maxElemStack.peek();
        if (maxElem.equals(returnElem)) {
            maxElemStack.pop();
        }
        return returnElem;
    }

    public T max() {
        return maxElemStack.peek();
    }
}
