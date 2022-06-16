import java.util.Arrays;

public class toCamelCase {

    public static void main(String[] args) {
        String input = "the-Stealth-Warrior";
        System.out.println(toCamelCase(input));
    }


    static String toCamelCase(String input) {
        StringBuilder answer = new StringBuilder();
        String[] foo = input.split("-");
        String[] bar = input.split("_");
        boolean isFirstWord = true;
        if (bar.length > 1) {
            for (String word : bar) {
                if (isFirstWord) {
                    answer.append(word);
                } else {
                    answer.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
                }
                isFirstWord = false;
            }
        } else {
            for (String word : foo) {
                if (isFirstWord) {
                    answer.append(word);
                } else {
                    answer.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
                }
                isFirstWord = false;
            }
        }

        return String.valueOf(answer);
    }

    static String toCamelCaseM(String str){
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }
}
/*
Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case).
Examples
"the-stealth-warrior" gets converted to "theStealthWarrior"
"The_Stealth_Warrior" gets converted to "TheStealthWarrior"
 */