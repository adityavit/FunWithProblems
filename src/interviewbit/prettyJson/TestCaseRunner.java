package interviewbit.prettyJson;

import java.util.List;

/**
 * Created by adib on 9/10/16.
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        List<String> result = sol.prettyJSON("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}");
        List<String> result = sol.prettyJSON(("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}"));
        for(String value: result) {
            System.out.println(value);
        }
    }
}
