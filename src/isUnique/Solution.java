package isUnique;

/**
 * Created by adib on 5/22/16.
 */
public class Solution {

    /**
     * Checks for the ASCII code. Only works for extended ASCII characters.
     * Will Fall apart for the unicode characters.
     * @param s
     * @return
     */
    public boolean isUniqueASCII(String s){

        boolean[] asciiBitVector = new boolean[256];
        for(int i = 0; i < s.length(); i++) {
            if(asciiBitVector[s.charAt(i)] != true) {
                asciiBitVector[s.charAt(i)] = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
