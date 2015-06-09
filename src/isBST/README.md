validate binary search tree.

https://leetcode.com/problems/validate-binary-search-tree/

This problem can be solved following ways other than O(n2) naive solution.

- Passing the MIN and MAX value in the recursive call.

Can start with Integer.MIN_VALUE and Integer.MAX_VALUE

Recursive call looks like this.

1. If the node is null return true. // This is for the case when the node is a leaf node in the tree.
2. Compare the node.value it should lie within the MIN and MAX value.
3. Make recursive calls as if the isBSTHelper(TreeNode node, int min, int max)
    1. Left sub tree
        ```
            isBSTHelper(node.left, min, node.value) // the maximum value for the left node will be the node value.
        ```
    2. Right sub Tree
        ```
            isBSTHelper(node.right, node.value, max) // the minimum value for the right node will be the node value.
        ```
So the code can be really simple.

```Java
    boolean isBSTHelper(TreeNode node, int min, int max) {
        if node == null
            return true;
        if node.value < min || node.value > max //Compare the value should not be less than min and not greater than max.
            return false;
        return isBSTHelper(node.left, min, node.value) && isBSTHelper(node.right, node.value, max);
    }

    // Call the helper using
    isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
```
Note: This method fails to work when the nodes have values which Integer.MIN_VALUE or Integer.MAX_VALUE.

- Doing inorderTraversal and saving the previous value and comparing with the next value.

    This is a really cool trick and works on a a very simple logic that if you do inorder traversal of a BST then elements
    would be in sorted order.

    Should use this in interview.

    Requires two ways to solve it either you can make a global variable which points to the previous node in the inorder
    traversal or in Java because you cannot take pointers of pointers then you have to box the previous node in another class
    and then pass recursively changing as required.(Code in Solution class)

    ```Java
       TreeNode prev;
       boolean isBSTHelper(TreeNode node) {
            if(node == null)
                return true;
            if(!isBSTHelper(node.left)) //Check for the left node for validity.
                return false;
            if(prev != null) { //This value can be null in the leftmost node of the tree.
                if(node.value < prev.value) // Check whether the node value is greater than the prev.value then it voilates BST.
                    return false;
            }

            prev = node; // This condition makes previous to the current node. This would set for the first time in leftmost node.

            //Check for the right node.
            if(!isBSTHelper(node.right))
                return false;
            return true; //return true if everything bases.
       }
    ```

