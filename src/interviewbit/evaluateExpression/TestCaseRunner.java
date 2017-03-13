package interviewbit.evaluateExpression;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by adib on 9/20/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Polish Notation
        String[] polishExp1 = {"*", "+", "2" , "1" ,"3"};
        ArrayList<String> pEList1 = new ArrayList<>(Arrays.asList(polishExp1));
        System.out.println(sol.evalPN(pEList1));
        String[] polishExp2 = {"+", "4", "/" , "13", "5"};
        ArrayList<String> pEList2 = new ArrayList<>(Arrays.asList(polishExp2));
        System.out.println(sol.evalPN(pEList2));

        //Reverse Polish Notation
        String[] rPolishExp1 = {"2", "1", "+", "3", "*"};
        ArrayList<String> rpEList1 = new ArrayList<>(Arrays.asList(rPolishExp1));
        System.out.println(sol.evalRPN(rpEList1));
        String[] rPolishExp2 = {"4", "13", "5", "/", "+"};
        ArrayList<String> rpEList2 = new ArrayList<>(Arrays.asList(rPolishExp2));
        System.out.println(sol.evalRPN(rpEList2));
    }
}
