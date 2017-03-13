package interviewbit.backtracking.letterPhone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/letter-phone/
 *
 * Created by adib on 10/11/16.
 */
public class Solution {
    static final Map<Character, Character[]> maping = new HashMap<>();
    static {
        maping.put('1', new Character[] {'1'});
        maping.put('2', new Character[] {'a', 'b', 'c'});
        maping.put('3', new Character[] {'d', 'e', 'f'});
        maping.put('4', new Character[] {'g', 'h', 'i'});
        maping.put('5', new Character[] {'j', 'k', 'l'});
        maping.put('6', new Character[] {'m', 'n', 'o'});
        maping.put('7', new Character[] {'p', 'q', 'r', 's'});
        maping.put('8', new Character[] {'t', 'u', 'v'});
        maping.put('9', new Character[] {'w', 'x', 'y', 'z'});
        maping.put('0', new Character[] {'0'});
    }


    /**
     * Initial Solution takes lot of memory as every digit creates 3 or 4 String builder objects,
     * Time: exponential (4^number of digits in string digits.
     * Space: It should take exponential memory as it has to store at least all the combinations,
     * but this program is creating more space.
     * @param digits
     * @return
     */
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        List<StringBuilder> resultants = letterCombinationsRecursive(digits, 0);
        for (StringBuilder resultant: resultants) {
            result.add(resultant.toString());
        }
        return result;
    }

    public List<StringBuilder> letterCombinationsRecursive(String digits, int index) {
        if (index == digits.length()) {
            return null;
        }
        List<StringBuilder> result = new ArrayList<>();
        Character ch = digits.charAt(index);
        Character[] map = maping.get(ch);
        List<StringBuilder> resultantList = letterCombinationsRecursive(digits, index + 1);
        for (int i = 0; i < map.length; i++) {
            if (resultantList != null) {
                for (StringBuilder resultant: resultantList) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(map[i]);
                    sb.append(resultant);
                    result.add(sb);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(map[i]);
                result.add(sb);
            }
        }
        return result;
    }
}

