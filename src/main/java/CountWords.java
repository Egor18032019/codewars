import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class CountWords {
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();

    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void close() throws IOException {
        bufferedReader.close();
    }

    private static void run() throws IOException {
        Map<String, Integer> hashMap = new HashMap<>();
        String line;
//        int count = 30;
//        System.out.println("начал работу");

        while (!(line = bufferedReader.readLine()).equals("")) {
//        while (count != 0) {
//            line = bufferedReader.readLine();
//            count--;
//            System.out.println(count);
            String[] arrFromLine = line.replaceAll("-", "").replaceAll("\\(", "")
                    .replaceAll("\\\"", "").replaceAll("\\.", "").replaceAll(",", "").split(" ");
            int length = arrFromLine.length;
            for (int i = 0; i < length; i++) {
                String key = arrFromLine[i].toLowerCase().trim();
                boolean isContains = hashMap.containsKey(key);
                if (isContains) {
                    int value = hashMap.get(key) + 1;
                    hashMap.put(key, value);
                } else {
                    hashMap.put(key, 1);
                }
            }
        }
        bufferedReader.close();
        if (hashMap.size() == 0) return;
// попробую таким образом
        Map<String, Integer> sortedMap = hashMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        List<String> keys = new ArrayList<String>(sortedMap.keySet());
        for (int i = 0; i < 50; i++) {
            System.out.print(keys.get(i) + " ");
        }

    }

}
