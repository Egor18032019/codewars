import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Tin5 {
    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        final int mans = Integer.parseInt(firstLine[0]);
        final int petition = Integer.parseInt(firstLine[1]);
// фио уникальные или нет ? если нет то переделать надо будет
        Map<String, Integer> original = new HashMap<String, Integer>();
        Map<String, Integer> sort = new HashMap<String, Integer>();
        String[] mansArr = new String[mans];
        for (int i = 1; i <= mans; i++) {
            String line = reader.readLine();
            original.put(line, i);
            mansArr[i - 1] = line;
        }
        // отсортировали
        Arrays.sort(mansArr); // по идееи можно не сортировать или флаги поставить ?

        for (int i = 0; i < petition; i++) {
            String[] petitionLine = reader.readLine().split(" ");
            int number = Integer.parseInt(petitionLine[0]);
            String prefix = petitionLine[1];
            // еще один цикл который с этим префиксом сделает массив
            List<String> listWithPrefix = new ArrayList<>();
            for (int w = 0; w < mansArr.length; w++) {
                String withPrefix = mansArr[w];
                boolean isHavePrefix = withPrefix.startsWith(prefix);
                if (isHavePrefix) {
                    listWithPrefix.add(withPrefix);
                }
            }
            String key = listWithPrefix.get(number - 1);

            System.out.println(original.get(key));
        }
        reader.close();
    }
}
/*
5 кол-во людей
--- исходный набор
ad
a
abc
aboba
b
--- Сортированный набор
a
abc
aboba
ad
b
-----
3 - обращения
3 a
2 ab
1 b
вывод
---
4 в сортированном наборе вытащили всех кто на а
нашли 3  = aboba и нашли его номер в исходном
---
4 - в сортированном наборе вытащили всех кто на ab
то есть
abc
aboba
взяли второго и нашли его в исходном
---
5 ну и тд
префикс - приставка или начало строки
 */