https://leetcode.com/problems/sum-root-to-leaf-numbers/

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,
```
    1
   / \
  2   3
```
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

A really good problem.

This problem is all about base conditions in the tree problem.

A really simple problem but hard to think of the easy solution.

General intuition says to calculate the sum bottom up in the DFS this will make the problem more difficult.
As you will have to pass the number up and then calculate the number of digits on the left sub tree and right sub tree.
The multiple that number times 10 to the root.val and then create the number at the node and then add the sum on the left and right sub tree.

This will take more complexity.

Although counter intuitive but the most easy way to solve this problem is to pass the sum from the top to the bottom and then return the sum by looking at that node.

For each level the sum can be calculated by taking the sum from the top multiple by 10 and then add the sum of that node. And that is the crux of this problem.

Then it is becomes a problem of just defining the bases cases.

Which are.
If root node is null return 0. This will be the case when root node is null.

In the case root.left is null and root.right is null then it is the leaf node. return the sum calculated till this node.

In the case root.left or root.right is null. Forget the sum of the branch is null i.e. take it as zero, and return the sum of the other branch.

Else in the case if both are present get their sum add them and return.
