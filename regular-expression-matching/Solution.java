public class Solution {
    public boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0) return true;
        if(s.length() == 1 && p.length() == 1) return s.charAt(0) == p.charAt(0);
        if(p.length() > 1 && p.charAt(1) != '*') {
            if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        } 
        if(p.length() > 1 && p.charAt(1) == '*') {
            int strChar = starMatch(s, p);
            if(p.length() > 2) {
                if(s.length() > strChar + 1) {
                    return isMatch(s.substring(strChar + 1), p.substring(2));
                } else {
                    boolean remainingMatch;
                    while(strChar > 0) {
                        remainingMatch = isMatch(s.substring(strChar), p.substring(2));
                        if(remainingMatch) {
                            return true;
                        } else {
                            strChar--;
                        }
                    }
                }
            } else {
                if(s.length() > strChar + 1) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int starMatch(String s, String p) {
        int strChar = 0;
        while(s.length() > strChar && (s.charAt(strChar) == p.charAt(0) || p.charAt(0) == '.')) {
            strChar++;
        }
        return strChar;
    }
}