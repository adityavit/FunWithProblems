https://leetcode.com/problems/permutations/

Problem to calculate permutations for the given array of numbers.

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

This is the case when all the elements are unique.

Solution:

Naive or brute force.

For this what i have done is taken a recursive approach.
Permutations for the element n of the array = placing the element n in every position for all the permutations of n-1 elements.

Total permutation because of this would be n * permutations of n-1

Permutation for one element = 1
permutation for 2 elements is 2 * P(1) = 2
permutation for 3 elements is 3 * P(2) = 6

so permutations for n elements is (n)!

Complexity:

Time Complexity:
The problem is exponential in time complexity

with the algorithm i have written it would be something like (n-1)! * (n-1) * n
of n!(n-1) which would be exponential.

Memory complexity is also exponential as at every step (n-1)! lists are received from previous step and
n are created for each one of the these (n-1)! lists.

A special taken has to be done when placing the currentElement in the last position of the permutation as the inner loop of i
will complete before it can be placed so it has to be added specially as in the line no 29.
