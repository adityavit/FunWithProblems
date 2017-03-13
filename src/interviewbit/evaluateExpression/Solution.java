package interviewbit.evaluateExpression;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * http://www.geeksforgeeks.org/expression-evaluation/
 * Created by adib on 9/20/16.
 */
public class Solution {

    /**
     * https://en.wikipedia.org/wiki/Polish_notation
     * When the expression is polish notation
     * For Example:
     * ["*", "+", "2" , "1" ,"3"] -> ((2 + 1) * 3) -> 9
     * ["+", "4", "/" , "13", "5"] -> (4 + (13 / 5)) -> 6
     * This is a pre order traversal of the tree for calculating the expression.
     * Both uses the same algorithm, just that you read the list from right to left rather than left to right like in the case or reverse polish notation.
     * Also the first value poped out of the stack will be operand1 and second value would be operand 2.
     * @param a
     * @return
     */
    public int evalPN(ArrayList<String> a) {
        Deque<Integer> stack = new LinkedList<>();
        if ( a == null || a.size() == 0) {
            return 0;
        }
        int len = a.size();
        int i = len - 1;
        while ( i >= 0) {
            String elem = a.get(i);
            if ( elem.equals("+") || elem.equals("-") || elem.equals("*") || elem.equals("/")) {
                Integer operand1 = stack.pop();
                Integer operand2 = stack.pop();
                switch(elem) {
                    case "+": stack.push(operand1 + operand2);
                        break;
                    case "-": stack.push(operand1 - operand2);
                        break;
                    case "*": stack.push(operand1 * operand2);
                        break;
                    case "/": stack.push(operand1 / operand2);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(elem));
            }
            i--;
        }
        int result = stack.pop();
        return result;
    }
    /**
     * https://www.interviewbit.com/problems/evaluate-expression/
     * When the expression is given in reverse polish notation.
     * For example
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     * Simply use one stack to solve this problem.
     * Whenever you see an operator just pop two values of the operator and apply the operator on it and push back result to the stack.
     * Be careful though the first poped value is operand2 and the second is operand1 otherwise in case of "-" and  "/" you will get wrong value.
     * which becomes operand1 operator operand2
     * @param a
     * @return
     * @accepted
     */
    public int evalRPN(ArrayList<String> a) {
        Deque<Integer> stack = new LinkedList<>();
        if ( a == null || a.size() == 0) {
            return 0;
        }
        int i = 0;
        int len = a.size();
        while ( i < len) {
            String elem = a.get(i);
            if ( elem.equals("+") || elem.equals("-") || elem.equals("*") || elem.equals("/")) {
                Integer operand2 = stack.pop();
                Integer operand1 = stack.pop();
                switch(elem) {
                    case "+": stack.push(operand1 + operand2);
                        break;
                    case "-": stack.push(operand1 - operand2);
                        break;
                    case "*": stack.push(operand1 * operand2);
                        break;
                    case "/": stack.push(operand1 / operand2);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(elem));
            }
            i++;
        }
        int result = stack.pop();
        return result;
    }
}
