import java.util.List;

public class BinaryTreePruning {
    TreeNode current;

    public TreeNode pruneTree(TreeNode root) {
        this.current = root;
        inorder(current);
        return current;
    }

    /*
    [1,0,1,0,0,0,1]
    Output
    [1,0,1,null,null,0,1]
    [1,2,1,null,null,2,1]
    Expected
    [1,null,1,null,1]
     */
    public void inorder(TreeNode root) {
        if (root == null) return;
        boolean right = false;
        boolean left = false;
        if (root.val == 0) {
            if (root.left != null) {
                if (root.left.val == 0) {
                    root.left = null;
                    right = true;
                }
            } else {
                right = true;
            }
            if (root.right != null) {
                if (root.right.val == 0) {
                    root.right = null;
                    left = true;
                }
            } else {
                left = true;
            }

        }
        if (right && left) {
            root = null;
        } else {
            inorder(root.left);
            inorder(root.right);
        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
/*
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        if (!a1) node.left = null;
        if (!a2) node.right = null;
        return node.val == 1 || a1 || a2;
    }
}
 */