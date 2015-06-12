https://leetcode.com/problems/recover-binary-search-tree/

A good Explanation of this problem is given at http://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/

The idea is to do a similar kind of way as was done for isBST. Using a previous node.

The only case to check for is when the two swapped nodes are adjacent to each other in that case condition

```
previousNode > root.value
```

will happen only once so the idea is to always save the root value in the secondSwapped value and if the above condition
happens twice then replace that value with root value.
