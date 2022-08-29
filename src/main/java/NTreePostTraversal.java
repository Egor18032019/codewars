import java.util.ArrayList;
import java.util.List;

public class NTreePostTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        if (root.children.isEmpty()) {
            answer.add(root.val);
            return answer;
        }
        inorder(root.children, answer);
        answer.add(root.val);
        return answer;
    }

    public void inorder(List< Node> children, List<Integer> list) {
        if (children.isEmpty()) return;
        for ( Node it : children) {
            inorder(it.children, list);
            list.add(it.val);
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

    ;
}
