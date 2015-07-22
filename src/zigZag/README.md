TopCoder [ZigZag problem.](http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493)

The Problem can be solved in O(n) complexity.

Add the base case for length = 1 and 2.
Mark whether the difference between the first two elements is positive or negative.

Iterate over the array from the 2 element till the last index.
If the difference of the i and i - 1 index element is positive but the previous difference was negative then the element is zig zag sequence.
So increase the count, and mark the difference as positive.

If the difference of i and i - 1 index element is negative and the previous difference was positive then the element is in zig zag sequence.
So increase the count, and mark the difference as negative.

otherwise skip the element.


