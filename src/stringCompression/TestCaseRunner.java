package stringCompression;


/**
 * Created by adib on 5/30/16.
 */
public class TestCaseRunner {

    public static void main(String args[]) {
        Solution sol = new Solution();
        assert sol.compressString("abc").equals("abc");
        assert sol.compressString("aabcccccaaa").equals("a2b1c5a3");
        assert sol.compressString("aaaa").equals("a4");
        assert sol.compressString("aa").equals("aa");

        assert sol.compressStringOptimal("abc").equals("abc");
        assert sol.compressStringOptimal("aabcccccaaa").equals("a2b1c5a3");
        assert sol.compressStringOptimal("aaaa").equals("a4");
        assert sol.compressStringOptimal("aa").equals("aa");
    }
}
