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
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < lifts; i++) {
            String[] line = reader.readLine().split(" ");

            map.put(i, Integer.valueOf(line[0] + line[1]));
            left.put(i, Integer.valueOf(line[0]));
            right.put(i, Integer.valueOf(line[1]));
        }
        reader.close();
//        отсортируем мапы по ключу и значению

        Map<Integer, Integer> sortMap = map.entrySet()
                .parallelStream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        int fistKey = (int) sortMap.keySet().toArray()[0];
         Tree tree = new Tree();
        for (Map.Entry<Integer, Integer> entry : sortMap.entrySet()) {
            int mainKey = entry.getKey();
            int leftForTree = left.get(mainKey);
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
                saveChild(root, left, right);
            }
        }


        public void saveChild(Node node, int left, int right) {

            if (node.right == left) {
                if (node.child.size() > 0) {
                    // если у этой ноды есть дети то надо и по ним пройтись
                    for (Node nextNode : node.child) {
                         saveChild(nextNode, left, right);
                    }
                }
                int lvl = node.level + 1;

                node.child.add(new Node(left, right, lvl));
                valueLevel.add(lvl);

            } else {
                for (Node nextNode : node.child) {

                    saveChild(nextNode, left, right);
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

-----

-----
3
2 2
2 2
0 2
   вывод 3
 */