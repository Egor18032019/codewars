import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Tin6 {
    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();

    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        final int lifts = Integer.parseInt(reader.readLine().trim());
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        Map<Integer, Integer> right = new HashMap<Integer, Integer>();
        for (int i = 0; i < lifts; i++) {
            String[] line = reader.readLine().split(" ");
            left.put(i, Integer.valueOf(line[0]));
            right.put(i, Integer.valueOf(line[1]));
        }
        reader.close();
//        отсортируем мапы по ключу и значению

        Map<Integer, Integer> sortLeft = left.entrySet()
                .parallelStream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        int fistKey = (int) sortLeft.keySet().toArray()[0];
        System.out.println("fistKey " + fistKey);
        Tree tree = new Tree();
        for (Map.Entry<Integer, Integer> entry : sortLeft.entrySet()) {
            int mainKey = entry.getKey();
            int leftForTree = sortLeft.get(mainKey);
            int rightForTree = right.get(mainKey);
            tree.insert(leftForTree, rightForTree);
        }
        System.out.println(tree.giveMaxLvl());
    }

    public static class Tree {

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
}
/*
начинаем с 0 же ???
0-2
2-2
2-2
2-5
5-6
6-8

7
6 8
5 6
2 6
2 5
2 2
2 2
0 2
 */