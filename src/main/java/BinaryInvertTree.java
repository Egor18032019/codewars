public class BinaryInvertTree {

    public TreeNode invertTree(TreeNode root) {
        TreeNode invTree = order(root);

        return invTree;
    }

    public TreeNode order(TreeNode root) {
        if (root == null) return root;
        // создали пререкладчик
        TreeNode point = root.left;
        root.left = root.right;
        root.right = point;

// и вызываем рекурсию на следующий слой
        // То есть сначала поменяли верхние , потом спустились и ниже поменяли и так до конца
        order(root.left);
        order(root.right);

        return root;
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
