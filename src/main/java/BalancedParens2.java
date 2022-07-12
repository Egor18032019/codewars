import java.util.ArrayList;
import java.util.List;

public class BalancedParens2 {
    public static void main(String[] args) {
        System.out.println(balancedParens(3));
    }

    public static List<String> balancedParens(int n) {
        List<String> parenthesisList = new ArrayList<String>();
        makeParenthesis(parenthesisList, new char[2 * n],
                0, n, 0, 0);
        return parenthesisList;
    }

    static void makeParenthesis(List<String> parenthesisList, char[] parenthesis,
                                int pos, int length, int open, int close) {
        if (close == length) {
            parenthesisList.add(String.valueOf(parenthesis));
        } else {
// на втором шаге pos = 1 и open =1 , length = 3  и опять вызывается makeParenthesis
            // в итоге в стеке вызова уже две функцкии makeParenthesis с причем с разными аргументами
            if (open > close) {
                parenthesis[pos] = ')';
                makeParenthesis(parenthesisList, parenthesis, pos + 1, length, open, close + 1);
            }
            // начало всё по нулям кроме length и вызывается makeParenthesis
            if (open < length) {
                parenthesis[pos] = '(';
                makeParenthesis(parenthesisList, parenthesis, pos + 1, length, open + 1, close);
            }

        }
    }
}
