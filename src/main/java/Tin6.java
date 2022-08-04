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
        final int lifts = Integer.parseInt(reader.readLine());
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
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println(tree.giveMaxLvl());
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