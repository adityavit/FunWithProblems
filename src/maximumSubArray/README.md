https://leetcode.com/problems/maximum-subarray/

This Problem can be solved in many ways.
Sample Input:

[−2,1,−3,4,−1,2,1,−5,4]

largest sum : 6
containing elements : [4,−1,2,1]

Lets start with solving the problem in brute force way or the least efficient way.

Basically the idea is to find all the sub arrays and then check their sum and give the maximum sum.
A pseudo code for such algorithm would be something like.
```java
int maxSum;
for(int i=0; i<nums.length; i++ ) {
    for(int j=i; j< nums.length; j++ ) {
        int subArraySum = 0;
        for(int k =i; k<=j; k++) {
            subArraySum = subArraySum + nums[k];
         }
         maxSum = Math.max(subArraySum, maxSum);
     }
 }
 ```

 This doesn't handle the negative number case. But this has a complexity of O(n3). And gives time exceeded error.

 It is easy to convert this into a quadratic solution.

 basically in the inner most loop rather than iterating over all the i and j we just we can just store the value of sum rather
 than iterating over the elements in the k loop.

```java
int maxSum =0;
for(int i=0; i<nums.length; i++ ) {
    for(int j=i; j< nums.length; j++ ) {
        int subArraySum = 0;
        subArraySum = subArraySum + nums[j];
        maxSum = Math.max(subArraySum, maxSum);
    }
}
```

There are two ways to linear solution:
* Divide and Conquer.
* scanning. (Given in function maxSubArray)

Divide and Conquer

This method is really cool. And gives the way to solve divide and conquer problems.

Basic Idea is divide the list into two parts. Either the maxSum would in the first part of the list or the maxSum would be in the second part.
And the third case where the max sum can overlap the two list. This part is kind of tricky.

Base cases.
If the list contains one element return 0 in case it is negative or that number itself.

If the start and end crosses eah other return 0;





