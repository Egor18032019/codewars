import java.util.*;

public class Tree {

    Node root;
    Set<Integer> valueLevel = new HashSet<>();

    public void insert(int left, int right) {
        if (root == null) {
            root = new Node(left, right, 1);
            valueLevel.add(1);
        } else {
            if (left == root.right) {
                int lvl = root.level + 1;
                valueLevel.add(lvl);
                root.child.add(new Node(left, right, lvl));
            } else {
                // запустили рекурсию которая копает в глубь
                saveChild(root.child, left, right);
            }

        }
    }


    public void saveChild(List<Node> child, int left, int right) {
        for (Node nextnode : child) {
            if (nextnode.right == left) {
                int lvl = nextnode.level + 1;
                nextnode.level = lvl;
                nextnode.child.add(new Node(left, right, lvl + 1));
                valueLevel.add(lvl + 1);
            } else {
                saveChild(nextnode.child, left, right);
            }
        }
    }

    public int giveMaxLvl() {
        int max = Collections.max(valueLevel);
        return max;
    }

    public class Node {

        int left;
        int right;
        int level;
        List<Node> child;

        Node(int left, int right, int level) {
            this.left = left;
            this.right = right;
            this.level = level;
            child = new ArrayList<>();
        }

        /**
         * Метод который выводит на экран содержимое узла
         */
        public void printNode() {
            System.out.println("left " + left + " right: " + right + "size " + child.size());
        }
    }
}



/*
/6 8
5 6     /6 8
2 5     2 6
    2 2
    2 2
    0 2
 */