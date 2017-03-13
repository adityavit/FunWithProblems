package stringCompression;

/**
 * Created by adib on 5/30/16.
 */
public class Solution {

    /**
     * Compress string to the form aabcccccaaa -> a2b1c5a3 if the string is smaller than the compressed string return that.
     * abc -> a1b1c1 return abc
     * This is not the optimal solution because String class is immutable so in the for loop it is creating a new string each time and copying over the values.
     * Complexity = O(n^2) Because for every character which is different it iterates over the compressed string.
     * Hint: Use StringBuilder class.
     * @param inputStr
     * @return
     */
    public String compressString(String inputStr) {
        if (inputStr == null || inputStr == "" || inputStr.length() == 1) {
            return inputStr;
        }
        String returnStr = "";
        int charPtr = 0, indexPtr = 1;
        while(indexPtr < inputStr.length()) {
            if(inputStr.charAt(charPtr) != inputStr.charAt(indexPtr)) {
                int charCount = indexPtr - charPtr;
                returnStr = returnStr + inputStr.charAt(charPtr) + charCount;
                charPtr = indexPtr;
            }
            indexPtr++;
        }
        returnStr = returnStr + inputStr.charAt(charPtr) + (indexPtr - charPtr);
        return returnStr.length() < inputStr.length()? returnStr : inputStr;
    }

    /**
     * Optimal way of solving the problem.
     * Complexity is O(n)
     * @param inputStr
     * @return
     */
    public String compressStringOptimal(String inputStr) {
        StringBuilder sb = new StringBuilder();
        if (inputStr == null || inputStr == "" || inputStr.length() == 1) {
            return inputStr;
        }
        int charPtr = 0, indexPtr = 1;
        while(indexPtr < inputStr.length()) {
            if(inputStr.charAt(charPtr) != inputStr.charAt(indexPtr)) {
                sb.append(inputStr.charAt(charPtr)).append(indexPtr - charPtr);
                charPtr = indexPtr;
            }
            indexPtr++;
        }
        sb.append(inputStr.charAt(charPtr)).append(indexPtr - charPtr);
        return sb.length() < inputStr.length()? sb.toString() : inputStr;
    }
}
