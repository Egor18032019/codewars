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
        Map<Integer, Integer> chain = new HashMap<Integer, Integer>();
        Set<Integer> steps = new HashSet<>();
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
        Map<Integer, Integer> sortRight = right.entrySet()
                .parallelStream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        System.out.println("sortRight " + sortRight.keySet().toArray()[0]);
        int foo = 0;
        int fistKey = (int) sortLeft.keySet().toArray()[0];
        System.out.println("fistKey " + fistKey);
        // достаем из правого по fistKey
//        sortRight.get(fistKey) = 2
        //удалили по fistKey там и там
        //
/*  в итоге две мапы
6 0

0 2
2 2
3 2
5 2

1 5
4 6

3 2
5 2
6 2
2 5
0 6
4 8
  */
    }

//    public static int giveMeSteps() {
//
//    }

    public static List<Integer> getKeyList(HashMap<Integer, Integer> map, Integer value) {
        List<Integer> keyList = new ArrayList();
        for (Integer getKey : map.keySet()) {
            if (map.get(getKey).equals(value)) {
                keyList.add(getKey);
            }
        }
        return keyList;
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