import java.util.*;

// так и не понял задание
public class SmallestSubtree {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode answer = null;
        Map<TreeNode, Integer> mapFromTree = new HashMap<>();
//        int max = deepTree(root);
//        System.out.println(max);
        if(root.left==null&&root.right==null){
            return root;
        }
        if (root != null) inorder(root, 1, mapFromTree);
        // потом из мапы вытаскиваем максимальный ключ
        int maxValueInMap = (Collections.max(mapFromTree.values()));

        // и по ключу вытаскиваем TreeNode у которого есть left и? или ? right ?
        for (Map.Entry<TreeNode, Integer> entry : mapFromTree.entrySet()) {
            if (entry.getValue() == maxValueInMap -1) {
                System.out.println(maxValueInMap);
                TreeNode curr = entry.getKey();
                if (curr.left != null && curr.right != null) {
                    // а если их две и более ??
                   return curr;
                }
                if (curr.left != null ) {

                    return curr.left;
                }
                if ( curr.right != null) {

                    return curr.right ;
                }
            }
        }
        return answer;
    }

    // мы из дерева делаем мапу. Key значение узла а Value глубина/высота элемента
    public void inorder(TreeNode root, int deep, Map<TreeNode, Integer> mapFromTree) {
        if (root == null) return;
        mapFromTree.put(root, deep);
        inorder(root.left, deep + 1, mapFromTree);
        inorder(root.right, deep + 1, mapFromTree);
    }

    /**
     * Максимальный элемент узла
     *
     * @param root TreeNode
     * @return Int
     */
    private int deepTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(deepTree(root.left), deepTree(root.right));
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
