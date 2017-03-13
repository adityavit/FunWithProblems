https://www.topcoder.com/community/data-science/data-science-tutorials/computational-complexity-section-2/

In the case of backtracking algorthims where the number of unique solutions are exponential, the lower bound of the solution will be exponential.
Irrespective of the implementation. In such cases it is easy to say that the algorithm is exponential, because whatever your implementation would be
it can't be smaller than the lower bound. It is similar to saying that the lower bound on the sorting is O(nlog n) and so no comparison based sort
can be less than nlogn irrespective of the solution.

So you can give lower bound of the complexity as the number of solutions, you algorithm is generating.

In this case a trivial lower bound on the time complexity is the number of possible solutions.
Backtracking algorithms are usually used to solve hard problems – i.e. such that we don’t know whether a significantly more efficient solution exists.
Usually the solution space is quite large and uniform and the algorithm can be implemented so that its time complexity is close to the theoretical lower bound.
To get an upper bound it should be enough to check how much additional (i.e. unnecessary) work the algorithm does.

The number of possible solutions, and thus the time complexity of such algorithms, is usually exponential – or worse.



Template for common problems on backtracking questions.

https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning


One thing to remember about these problems is.

There can be two ways to solve the problems.
1. The recursive function returns the result and you iterate over the results and prefix the current value to each of the results.
   Also see if the result is unique or not using a hash or set.
   This approach complexity wise won't buy anything, as in any case you have to generate exponential results in such problems.
   Even if you hashmap it will just make sure to that the results are created once.
   The biggest disadvantage of this method is that there are many objects which get created at every recursion level.

   Therefore a better approach is the second one.

2. In this approach we create a currentResult array or list or string. Then we pass this along with the result list of lists or strings
   in the recursive call. Then we find a base case where the current result can be added to the result list of lists.
   This is usually at the top of the stack like in the permutation case when it current result size is equal to the total number of elements.
   Or it can be when we reach the end of the list. In such base cases we add the current result to the result list of lists.

   Before calling the recursive call we add the current element to the current result list and at the end of the recursive call we remove the
   current element from the current result list. These two steps are important to come back to the plain slate at the start of every path in
   DAG.

   Complexity wise this method recurse over one solution at a time, and depending upon the solutions which are exponential in such problems.
   Time complexity is also exponential. This is not any different then above, but it takes much less memory at every stack level.

   So this is the method to be considered.