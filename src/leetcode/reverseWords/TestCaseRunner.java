package leetcode.reverseWords;

/**
 * Created by adib on 8/13/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //TestCase1
        String testCase1 = "The sky is blue";
        String testCase1Sol = sol.reverseWords(testCase1);
        assert testCase1Sol.equals("blue is sky The");
        System.out.println(sol.reverseWords(testCase1));

        String testCase2 = " The sky is blue ";
        String testCase2Sol = sol.reverseWords(testCase2);
        assert testCase2Sol.equals("blue is sky The");
        System.out.println(sol.reverseWords(testCase2));

        String testCase3 = " The   sky   is   blue ";
        String testCase3Sol = sol.reverseWords(testCase3);
        assert testCase3Sol.equals("blue is sky The");
        System.out.println(sol.reverseWords(testCase3));

        char[] testCase4 = "The sky is blue".toCharArray();
        sol.reverseWords(testCase4);
        assert testCase4.equals("blue is sky The");
        System.out.println(testCase4);

        char[] testCase5 = " The sky is blue ".toCharArray();
        sol.reverseWords(testCase5);
        assert testCase5.equals("blue is sky The");
        System.out.println(testCase5);

        char[] testCase6 = " The   sky   is   blue ".toCharArray();
        sol.reverseWords(testCase6);
        assert testCase6.equals("blue is sky The");
        System.out.println(testCase6);


    }
}
