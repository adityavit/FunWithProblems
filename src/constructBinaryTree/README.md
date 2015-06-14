https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Constructs a binary Tree from preorder and inorder array. An important consideration is that there are no duplicates.

The solution follows an algorithm described in the
[leetcode](http://articles.leetcode.com/2011/04/construct-binary-tree-from-inorder-and-preorder-postorder-traversal.html)

and
[geeks4geeks](http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/)

Algorithm in my words :)

The Solution is based on the idea that the root element is the first element in the preorder array.

Now once you find the root node search in the preorder array, search the element index in the inorder array and finds it's index.

Once you get the index look how many elements are there in the left of the root and how many are there in the right of the root.

The elements in the left will make the left sub tree and the elements in the right part will make the right sub tree.

Calculate that many element in the preorder element after the root element which will passed to the recursive call to create the left sub tree.

And similarly pass the remaining element of the right sub tree to the recursive call to return the right sub tree.

return the root node tree.


Complexity in general of this algorithm will nlogn, but in the worst case the complexity will O(n2) as tree can be skewed to the left and right.

So you will have to search the whole inorder array for each element.

But the O(n) complexity is coming from the linear search, what if we can reduce that using a Map with keys as the element to be search and value as
the index. This will bring the complexity to O(n) overall, considering that hashmap takes O(1) to search the element.

A similar idea has to be followed when postorder and inorder are given as the root element would be the last element in the postorder array.

