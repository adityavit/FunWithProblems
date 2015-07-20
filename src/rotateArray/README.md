https://leetcode.com/problems/rotate-array/

This problem is filled with edge cases and needs to be very careful, while writing conditions for this problem.

A simple way to solve this problem.
1) Take an auxiliary array for the rotation.
2) Take the last k items in the input array so start from n - 1 to n - k and place them in the first k elements of the
rotated array. So from k - 1 to 0; n - 1 - (n - k ) = k - 1 = k - 1 - 0
3) Place the remaining item from 0 to n - k items from 0 to n - k - 1 in the input array to k to n - 1 in the rotated array.
So n - k - 1 -0 = n - 1 - k = n - k - 1. Which are n - k elements.

Then place n values from rotated array back to already present array.
In the case of k = 0 and k = n the result remains same, which is the array doesn't rotate at all. Although this case would be handled by
the above conditions. Though you can just return in such cases without doing anything. So a base case for such condition would be good.

If k = 0 then 1 step won't got in loop and all the work will be done by step 2.
If k = n then 1 step will execute n times and second loop won't execute.

Special care has to be when k > n, in that case k can be written as k = k % n.
example k = 2 and n = 1 then k = 2 % 1 = 0 so no changes to the array. And if you think if the array is of size 1 it will not change
in any number of rotations.

Running time O(n), space complexity is O(n) though.


How to solve it in in-place or better can it be done in O(k) ?