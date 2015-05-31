
/**
 * Created by adib on 5/11/15.
 */
public class TreeBuilder {

    public static TreeNode treeDeSerializer(Integer[] treeElements) {
        TreeNode root;
        if (treeElements.length == 0) {
            return null;
        } else {
            if(treeElements[0] != null) {
                root = attachChild(0, treeElements);
                return root;
            }
            else
                return null;
        }
    }

    private static TreeNode attachChild(int parentIndex, Integer[] treeElements) {
        if(parentIndex > treeElements.length - 1) {
            return null;
        }
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        TreeNode parent = new TreeNode(treeElements[parentIndex]);
        if(leftChildIndex < treeElements.length) {
            if(treeElements[leftChildIndex] != null) {
                parent.left = attachChild(leftChildIndex, treeElements);
            } else {
                parent.left = null;
            }
        }
        if(rightChildIndex < treeElements.length) {
            if(treeElements[leftChildIndex] != null) {
                parent.right = attachChild(rightChildIndex, treeElements);
            } else {
                parent.right = null;
            }
        }
        return parent;
    }
}
