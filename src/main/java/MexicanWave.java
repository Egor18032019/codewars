import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MexicanWave {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(wave("two words")));
    }

    public static String[] wave(String str) {
        // Your code here
        int lengthWord = str.length();

        List<String> foo = new ArrayList<String>();
        for (int i = 0; i < lengthWord; i++) {
            String part = str.substring(i, i + 1).trim();
            boolean isEmpty = part.isEmpty();
            if (!isEmpty) {
                String portion = str.substring(0, i) + str.substring(i, i + 1).toUpperCase() + str.substring(i + 1, lengthWord);
                foo.add(portion);
            }
        }
        return foo.toArray(new String[0]);
    }

}
/*
  static String[] wave(String str) {
    return range(0, str.length())
        .filter(n -> str.charAt(n) != ' ')
        .mapToObj(n -> str.substring(0, n) + Character.toUpperCase(str.charAt(n)) + str.substring(n + 1))
        .toArray(String[]::new);
  }
 */