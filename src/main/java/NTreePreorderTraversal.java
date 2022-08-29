import java.util.ArrayList;
import java.util.List;

public class NTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        answer.add(root.val);
        if (root.children.isEmpty()) {
            return answer;
        }
        inorder(root.children, answer);

        return answer;
    }

    public void inorder(List<Node> children, List<Integer> list) {
        if (children.isEmpty()) return;
        for (Node it : children) {
            list.add(it.val);
            inorder(it.children, list);
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


}
