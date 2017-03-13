package interviewbit.simpleDirectoryPath;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/simplify-directory-path/
 * Created by adib on 9/17/16.
 */
public class Solution {
    public String simplifyPath(String a) {
        if (a == null || a.length() == 0 || a.equals("/")) {
            return "/";
        }
        Deque<String> stack = new LinkedList<>();
        int i = 0;
        String[] directories = a.split("\\/");
        int len = directories.length;
        while (i<len) {
            if (directories[i].equals(".") || directories[i].equals("")) {
                i++;
                continue;
            }
            if (directories[i].equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(directories[i]);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> reverseIt = stack.descendingIterator();
        while (reverseIt.hasNext()) {
            sb.append("/");
            sb.append(reverseIt.next());
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}

