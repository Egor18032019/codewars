import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inorder(root, answer);

        return answer;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list); // с начало бежим по левой части
        list.add(root.val);  // когда пробежали по левой части то добаляем корень и бежим по правой
        inorder(root.right, list); // когда пробежали по левой части бежим по правой
        // то есть в итоге мы получаем отсортированный массив значений с дерева
    }

    public class TreeNode {
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
