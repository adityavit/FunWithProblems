package interviewbit.justifiedText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adib on 9/8/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] wordsArr = {"What", "must", "be", "shall", "be."};
        ArrayList<String> words = new ArrayList<>(Arrays.asList(wordsArr));
        System.out.println(sol.fullJustify(words, 12));
    }
}
