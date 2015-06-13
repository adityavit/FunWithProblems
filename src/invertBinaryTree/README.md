Problem from leetcode. About inverting a tree.

Invert a binary tree.
```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```
to
```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```
Based on a problem asked Max howell created of homebrew in google. Problem created round of influx on internet and went viral.
Although problem is really simple.

Just invert the left tree and put it in the right child of the root.
Similarly invert right tree and put it in the left child of the root.

return new root.

