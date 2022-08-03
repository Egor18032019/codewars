import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Tin7 {


    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();

    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        final String magazine = reader.readLine();
        final int sections = Integer.parseInt(reader.readLine());
        for (int i = 0; i < sections; i++) {
            String[] line = reader.readLine().trim().split(" ");
            int begin = Integer.parseInt(line[0]) - 1;
            int end = Integer.parseInt(line[1]);
            String point = magazine.substring(begin, end);
            String[] sortLine = point.split("");
            String[] realLine = point.split("");
            System.out.println(Arrays.toString(sortLine));
            Arrays.sort(sortLine);
            int prevPlace = 0;
            int step = 0;
            for (String foo : sortLine) {
                while (true) {
                    if (prevPlace > (realLine.length - 1)) {
                        prevPlace = 0;
                    }
                    // ходим не по магазину а по подотрезку !!!
//                    Зачем тогда план магазина ??
                    boolean isNextItem = realLine[prevPlace].equals(foo);

                    if (isNextItem) {
                        break;
                    }
                    step++;
                    prevPlace++;
                }
            }
            System.out.println(step);
        }
        reader.close();
    }

}
/*

Для первого подотрезка из входных данных нужно сделать ﻿﻿9﻿﻿ перемещений: ﻿﻿
1﻿﻿ шаг с первого символа подотрезка до буквы ﻿﻿e﻿﻿,
4﻿﻿ шага до буквы ﻿﻿ h﻿﻿,
2﻿﻿ шага до первой ﻿﻿l﻿﻿, ﻿﻿
1﻿﻿ шаг до второй  ﻿﻿l﻿﻿, ﻿﻿
1﻿﻿ шаг до буквы ﻿﻿  o﻿﻿.
Примеры данных

hello
3
1 5 - hello
1 2 - he
2 5 - ello
 */