package EPI.StacksAndQueue.StackWithMaxAPI;

/**
 * Created by adib on 6/24/17.
 */
public class Solution {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack();
        st.push(7);
        st.push(3);
        st.push(2);
        assert st.max() == 7;
        st.push(7);
        st.push(6);
        assert st.max() == 7;
        st.push(8);
        assert st.max() == 8;
        st.pop();
        assert st.max() == 7;
        st.pop();
        assert st.max() == 7;
        st.pop();
        assert st.max() == 7;


        // Test case of the book.
        Stack <Integer> st2 = new Stack();
        st2.push(2);
        assert st2.max() == 2;
        st2.push(2);
        assert st2.max() == 2;
        st2.push(1);
        assert st2.max() == 2;
        st2.push(4);
        assert st2.max() == 4;
        st2.push(5);
        assert st2.max() == 5;
        st2.push(5);
        assert st2.max() == 5;
        st2.push(3);
        assert st2.max() == 5;
        st2.pop();
        assert st2.max() == 5;
        st2.pop();
        assert st2.max() == 5;
        st2.pop();
        assert st2.max() == 4;
        st2.pop();
        assert st2.max() == 2;
        st2.push(0);
        assert st2.max() == 2;
        st2.push(3);
        assert st2.max() == 3;
    }
}
