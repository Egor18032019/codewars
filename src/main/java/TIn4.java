import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TIn4 {

    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void close() throws IOException {
        reader.close();
    }

    private static void run() throws IOException {
        Map<String, String> original = new HashMap<String, String>();
        Map<String, String> change = new HashMap<String, String>();
//        if (!reader.readLine().equals("{")) {
//            System.out.println("Error !!");
//        }
        int countBrace = 0;
        boolean miniBraceOpen = false;
        boolean isInit = true;
        while (true) {
            String line = reader.readLine().trim();
            if (line.equals("{")) {
                countBrace++;
                miniBraceOpen = true;
            }
            if (line.equals("}")) {
                countBrace--;
                miniBraceOpen = false;
                if (countBrace == 0) {
                    //  после конца блока возвращается старое значение переменной
                    change = original;
                    System.out.println("the end ");
                }
            }
            if (line.length() > 1) {
                if (countBrace == 0 && isInit) {
                    String[] splitLine = line.split("=");
                    String key = splitLine[0];
                    if (original.containsKey(splitLine[1])) {
                        String value = original.get(splitLine[1]);
                        original.put(key, value);
                        change.put(key, value);
                        System.out.println(value);
                    } else {
                        String val = splitLine[1];
                        if (isNumber(val)) {
                            original.put(key, val);
                            change.put(key, val);
                        } else {
                            val = "0";
                            original.put(key, val);
                            change.put(key, val);

                        }
                        System.out.println(val);
                    }

                } else {
                    isInit = false;
                    String[] splitLine = line.split("=");
                    String key = splitLine[1];
                    if (change.containsKey(key)) {
                        String value = change.get(key);
                        change.put(splitLine[0], value);
                        System.out.println(value);
                    } else {
                        change.put(splitLine[0], key);
                        System.out.println(key);
                    }
                }
            }

        }

    }


    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '-') return false;
        }
        return true;
    }
}
/*
thats=zero
a=10
ten=a
aboba=ten
ten=-10
{
b=a
a=1337
c=a
}
{
d=a
e=aboba
}
lol=a
 */