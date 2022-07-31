import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BalancedParens {
    public static void main(String[] args) {
        System.out.println(balancedParens(3));
    }

    public static List<String> balancedParens(int n) {
        List<String> answer = new ArrayList<>();

        if (n == 0) {
            answer.add("");
            return answer;
        }
        if (n == 1) {`
            answer.add("()");
            return answer;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add('(');
            list.add(')');
        }
        permutate(answer, list, 0);
        answer.removeIf(s -> !isValid(s));
        return answer;
    }

    public static void permutate(List<String> answer, List<Character> list, int k) {
        for (int i = k; i < list.size(); i++) {
            Collections.swap(list, i, k);
            permutate(answer, list, k + 1);
            Collections.swap(list, k, i);
        }

        if (k == list.size() - 1) {
            String value = list.stream().map(String::valueOf).collect(Collectors.joining());
            if (!answer.contains(value)) {
                answer.add(value);
            }
        }
    }

    public static boolean isValid(String braces) {
        if (braces.length() % 2 != 0) {

            return false;
        }
        if (braces.length() == 0) {

            return true;
        }
        String lastIteration = braces;
        String currentIteration = braces;
        do {
            lastIteration = currentIteration;
            currentIteration = lastIteration.replace("()", "");
        } while (currentIteration.length() < lastIteration.length());
        return currentIteration.equals("");
    }
}
/*
Write a function which makes a list of strings representing all of the ways you can balance n pairs of parentheses
Examples

balancedParens(0) returns ArrayList<String> with element:  ""
balancedParens(1) returns ArrayList<String> with element:  "()"
balancedParens(2) returns ArrayList<String> with elements: "()()","(())"
balancedParens(3) returns ArrayList<String> with elements: "()()()","(())()","()(())","(()())","((()))"

 */