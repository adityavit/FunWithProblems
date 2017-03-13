package interviewbit.addBinaryString;

import java.io.StringWriter;
import java.util.EnumSet;

/**
 * Created by adib on 9/5/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addBinary("101011", "0001101"));
        System.out.println(sol.addBinaryBetter("101011", "0001101"));
        StringWriter sw = new StringWriter();
        sw.append('H');
        sw.append('E');
        sw.append('L');
        sw.append('L');
        sw.append('O');
        System.out.println(sw.toString());
        int num2ASCII = '2';
        System.out.println(Integer.valueOf("2c", 16));
    }
}