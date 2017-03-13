package twitterInterview;

/**
 * Created by adib on 8/2/16.
 */
// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * tm.put("a", 1);
 * tm.put("b", 2);
 * tm.beginTransaction();
 * System.out.println(tm.get("a")); // 1
 * tm.put("a", 3);
 * System.out.println(tm.get("a")); // 3
 * System.out.println(tm.get("b")); // 2
 * tm.abortTransaction();
 * System.out.println(tm.get("a")); // 1
 * System.out.println(tm.get("b")); // 2
 * tm.beginTransaction();
 * tm.put("a", 4);
 * tm.beginTransaction();
 * System.out.println(tm.get("a")); // 4
 * tm.put("a", 5);
 * System.out.println(tm.get("a")); // 5
 * tm.abortTransaction();
 * System.out.println(tm.get("a")); // 4
 * tm.commitTransaction();
 * System.out.println(tm.get("a")); // 4
 */

public class TransactionMap {
    Map<String, Integer> baseMap;
    List<Map<String,Integer>> mapList;
    int mapPointer;
    public TransactionMap() {
        baseMap = new HashMap<String, Integer>();
        mapList = new ArrayList<Map<String,Integer>>();
        mapList.add(baseMap);
        mapPointer = 0;
    }

    public void put(String key, Integer value) {
        Map<String, Integer> currentMap = mapList.get(mapPointer);
        currentMap.put(key, value);
    }

    public Integer get(String key) {
        for (int i = mapPointer ; i > 0 ; i--) {
            Map<String, Integer> tempMap = mapList.get(i);
            if (tempMap.get(key) != null) {
                return tempMap.get(key);
            }
        }
        return baseMap.get(key);
    }

    public void beginTransaction() {
        Map<String, Integer> tempMap = new HashMap<String, Integer>();
        mapList.add(tempMap);
        mapPointer++;
    }

    /**
     * begin // mapPointer = 1, mapList = List(transaction1)
     * abort // mapPointer = 0, mapList = List(transaction1)
     * begin // mapPointer = 1, mapList = List(transaction1, transaction2)
     */

    public void abortTransaction() {
        if (mapPointer > 0) {
            mapList.remove(mapPointer);
            mapPointer--;
        }
    }

    public void commitTransaction() {
        for (int i = mapPointer ; i > 0 ; i--) {
            Map<String, Integer> tempMap = mapList.get(i);
            for(String key : tempMap.keySet()) {
                baseMap.put(key, tempMap.get(key));
            }
        }
        mapPointer = 0;
    }
}
