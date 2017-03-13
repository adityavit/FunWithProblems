package isUnique;

/**
 * Created by adib on 5/22/16.
 */
public class TestCaseRunner {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String trueString = "abcde";
        String falseString = "abcabc";

        boolean shouldBeTrue = sol.isUniqueASCII(trueString);
        assert shouldBeTrue;

        boolean shouldBeFalse = sol.isUniqueASCII(falseString);
        assert !shouldBeFalse;

//        String testString = "ॐ";
//        byte[] bytes = testString.getBytes();
//        System.out.println(bytes.length);
//        for(byte b : bytes) {
//            System.out.println(Integer.toHexString(b & 0xFF));
//        }
//        System.out.println(Character.codePointAt(testString.toCharArray(),0));
    }
}


