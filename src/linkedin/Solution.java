package linkedin;

/**
 * https://leetcode.com/problems/shortest-word-distance/
 * Created by adib on 8/23/16.
 */
public class Solution {
//    public void functionName() {
///* This class will be given a list of words (such as might be tokenized
// * from a paragraph of text), and will provide a method that takes two
// * words and returns the shortest distance (in words) between those two
// * words in the provided text.
// * Example:
// *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
// *   assert(finder.distance("fox","the") == 3);
// *   assert(finder.distance("quick", "fox") == 1);
// *
// * "quick" appears twice in the input. There are two possible distance values for "quick" and "fox":
// *     (3 - 1) = 2 and (4 - 3) = 1.
// * Since we have to return the shortest distance between the two words we return 1.
// */
//        // Input == {"the", "quick", "brown", "fox", "quick"}
//        // { "the": {0}, "quick" : { 1 , 4}, "brown" : {2} , "fox" : {3}}
//        //finder.distance("fox","the") ==>3
//        // wordOneIndexList => {3}
//        // wordTwoIndexList => {0}
//        //finder.distance("quick", "fox") ==>1
//        // wordOneIndexList => {1, 4}
//        // wordTwoIndexList => {3}
//        // minDistance = 2
//        // Min(2,1) =1
//
//        // wordOneIndexList => {1, 2, 3, 4, 15}
//        // wordTwoIndexList => {6, 7, 8, 9, 10}
//
//        public class WordDistanceFinder {
//            // Indexes of the words
//            Map<String, List<Integer> indexMap;
//            public WordDistanceFinder (List<String> words) {
//                // implementation here
//                indexMap = new HashMap<>();
//                if ( words != null ) {
//                    int i = 0;
//                    for (String word: words) {
//                        List<Integer> indexes = indexMap.get(word);
//                        if(indexes != null) {
//                            indexes.add(i);
//                        } else {
//                            indexes = new ArrayList<Integer>();
//                            indexes.add(i);
//                            indexMap.put(word, indexes);
//                        }
//                        i++;
//                    }
//                }
//
//            }
//            public int distance (String wordOne, String wordTwo) {
//                // implementation here
//                List<Integer> wordOneIndexes = indexMap.get(wordOne);
//                List<Integer> wordTwoIndexes = indexMap.get(wordTwo);
//                if (wordOneIndexes == null || wordTwoIndexes == null ) {
//                    return -1;
//                }
//                int minDistance = Integer.MAX_VALUE;
//                for ( Integer wordOneIndex : wordOneIndexes) {
//                    for ( Integer wordTwoIndex : wordTwoIndexes) {
//                        minDistance = Math.min(Math.abs(wordOneIndex - wordTwoIndex), minDistance);
//                    }
//                }
//                int lastIndex = 0;
//                for (Integer wordOneIndex : wordOneIndexes) {
//
//                    for (int i=lastIndex; i< wordTwoIndexList.size(); i++) {
//                        minDistance = Math.min(Math.abs(wordOneIndex - wordTwoIndexList.get(i)), minDistance);
//                        if (
//                    }
//                }
//                return minDistance;
//            }
//        }
//
//
///**
// * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth
// * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1)
// * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
// */
//        // Input {{1,1},2,{1,1}}
//        // depthSumHelper({{1,1},2,{1,1}}, 1)
//        // depthSumHelper({1,1}, 2) => 4
//        // sum = 2 + 2 => 4
//        // 2 * 1 => 2
//        // sum =6 (First stack)
//        // depthSumHelper({1,1}, 2) => 4
//        // sum = 10
//        // depthSum => 10
//        //
//        //{1,{4,{6}}}
//        // depthSumHelper({1,{4,{6}}}, 1) =>27
//        // sum = 1
//        //depthSumHelper({4,{6},2} => 26
//        // sum =4 *2 = 8
//        // depthSumHelper({6},3} ==>18
//        // sum = 6*3 => 18
//        //
//        public int depthSum (List<NestedInteger> input)
//        {
//            //Implementation here
//            if (input == null) {
//                return 0;
//            }
//            return depthSumHelper(input, 1);
//        }
//        private int depthSumHelper(List<NestedInteger> input, int depth) {
//            if (input == null) {
//                return 0;
//            }
//            int sum = 0;
//            for (NestedInteger elem : input) {
//                if ( elem.isInteger()) {
//                    sum += elem.getInteger()*depth;
//                } else {
//                    sum += depthSumHelper(elem.getList(), depth+1);
//                }
//            }
//            return sum;
//        }
//
///**
// * This is the interface that represents nested lists.
// * You should not implement it, or speculate about its implementation.
// */
//        public interface NestedInteger
//        {
//            /** @return true if this NestedInteger holds a single integer, rather than a nested list */
//            boolean isInteger();
//
//            /** @return the single integer that this NestedInteger holds, if it holds a single integer
//             * Return null if this NestedInteger holds a nested list */
//            Integer getInteger();
//
//            /** @return the nested list that this NestedInteger holds, if it holds a nested list
//             * Return null if this NestedInteger holds a single integer */
//            List<NestedInteger> getList();
//        }
//    }
}
