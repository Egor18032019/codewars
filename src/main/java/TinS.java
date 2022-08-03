import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TinS {
    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();

    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        int max = 0;
        final String firstLine = reader.readLine();
        int count = Integer.parseInt(firstLine);
//в каждой строке указаны три разделенных пробелом имени.
//        String[] storage = new String[count];
        Set<String> firstStorage = new HashSet<>();
        Set<String> secondStorage = new HashSet<>();
        Set<String> threeStorage = new HashSet<>();
        for (int i = 0; i < count; i++) {
            String[] line = reader.readLine().trim().split(" ");
            Arrays.sort(line);
            // так как строки уже должны быть остортированны то раскидываем по хранилищам

            if (i == 0) {
                firstStorage.add(line[0]);
                secondStorage.add(line[1]);
                threeStorage.add(line[2]);
            }
            if (i > 0) {
                // так как мы точно знаем что первая подстрока должна лежать в первом хранилище
                // и так далее ))
                if (firstStorage.contains(line[0]) && secondStorage.contains(line[1]) && threeStorage.contains(line[2])) {
                    max++;
                } else {
                    firstStorage.add(line[0]);
                    secondStorage.add(line[1]);
                    threeStorage.add(line[2]);
                }
            }
        }
        reader.close();

        System.out.println(max);
    }


}
