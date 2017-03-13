package interviewbit.prettyJson;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/pretty-json/
 * Created by adib on 9/10/16.
 * Problem is medium level, Good thing to remember is edge cases, as the interviewer about the edge cases.
 * Another good API stringBuilder.setLength(0) --> this sets the length 0 so that you don't create another object.
 */
public class Solution {
    public ArrayList<String> prettyJSON(String a) {
        ArrayList<String> result = new ArrayList<>();
        if ( a == null || a.length() == 0)
            return result;
        String tabCharacter = "\t";
        int i = 0;
        int len = a.length();
        int numOfTab = 0;
        StringBuilder sb = new StringBuilder();
        boolean charactersAdded = false;
        while ( i < len) {
            char currentChar = a.charAt(i);
            switch (currentChar) {
                case '{':
                case '[':
                    //Open braces increase tab count and then print next char form tab position.
                    if (sb.length() > 0 && charactersAdded) {
                        result.add(sb.toString());
                        charactersAdded = false;
                    }
                    sb.setLength(0);
                    for(int j = 0; j < numOfTab; j++) {
                        sb.append(tabCharacter);
                    }
                    sb.append(currentChar);
                    result.add(sb.toString());
                    sb.setLength(0);
                    numOfTab++;
                    for(int j = 0; j < numOfTab; j++) {
                        sb.append(tabCharacter);
                    }
                    break;
                case '}':
                case ']':
                    numOfTab--;
                    if (sb.length() > 0  && charactersAdded) {
                        result.add(sb.toString());
                        charactersAdded = false;
                    }
                    sb.setLength(0);
                    for(int j = 0; j < numOfTab; j++) {
                        sb.append(tabCharacter);
                    }
                    sb.append(currentChar);
                    if (i < len - 1 && a.charAt(i+1) != ',') {
                        result.add(sb.toString());
                        sb.setLength(0);
                    }
                    if (i == len - 1) {
                        //Is the last character above then append it
                        result.add(sb.toString());
                    }
                    break;
                case ',':
                    sb.append(currentChar);
                    result.add(sb.toString());
                    sb.setLength(0);
                    for(int j = 0; j < numOfTab; j++) {
                        sb.append(tabCharacter);
                    }
                    charactersAdded = false;
                    break;
                case ' ':
                    break;
                default:
                    //actual string key or value
                    sb.append(currentChar);
                    charactersAdded = true;
            }
            i++;
        }
        return result;
    }
}

