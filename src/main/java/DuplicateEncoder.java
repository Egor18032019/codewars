import java.util.Arrays;

public class DuplicateEncoder {
    public static void main(String[] args) {
        String f1 = "Prespecialized";
        String f2 = "   ()(   ";

        System.out.println(encode(f2));
        //")()())()(()()("
//        ")()())()(()()(

    }


    static String encode(String word) {
//        word.contains()
//        "dini"      =>  "()()"
        String workedWord = word.toLowerCase();
        String[] arrForWord = workedWord.split("");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < workedWord.length(); i++) {
            String bar = arrForWord[i];
            String foo = workedWord.substring(0, i) + workedWord.substring(i + 1, workedWord.length());
       //       answer += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
            boolean isOneSimbol = foo.contains(bar);
            if (isOneSimbol) {
                answer.append(")");
            } else {
                answer.append("(");
            }


        }

        return String.valueOf(answer);
    }
}

