import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BraceChecker {

    public static void main(String[] args) {
//        String braces = "([{}])";
//        String braces1 = "[(])";
        String braces2 = "(){}[]";
//        System.out.println(isValid(braces));
//        System.out.println(isValid(braces1));
        System.out.println(isValid(braces2));
    }

    public static boolean isValid(String braces) {
        if (braces.length() % 2 != 0) {
            System.out.println("Нечетное");
            return false;
        }
        if (braces.length() == 0) {
            System.out.println("Ничего");
            return true;
        }

        String lastIteration = braces;
        String currentIteration = braces;
        do {
            lastIteration = currentIteration;
            currentIteration = lastIteration.replace("[]", "").replace("{}", "").replace("()", "");
        } while (currentIteration.length() < lastIteration.length());
        return currentIteration.equals("");
    }
}
/*
}
Напишите функцию, которая принимает строку фигурных скобок и определяет, допустим ли порядок фигурных скобок. Он должен возвращать true, если строка действительна, и false, если она недействительна.

Этот Kata похож на Kata Valid Parentheses, но вводит новые символы: квадратные скобки [] и фигурные скобки {}. Спасибо @arnedag за идею!

Все входные строки будут непустыми и будут состоять только из круглых, квадратных и фигурных скобок: ()[]{}.
Что считается действительным?

Строка фигурных скобок считается допустимой, если все фигурные скобки соответствуют правильной фигурной скобке.
Примеры

'(){}[]' = Истина
'([{}])' = Истина
'(}' = Ложь
'[(])' = Ложь
'[({})](]' = Ложь
 */


/*                  row
---------------------------------------------------
s    |                I
t    | v          {5, 3, 4,    6, 7, 8,   9, 1, 2},
r    |            {6, 7, 2,    1, 9, 5,   3, 4, 8},
o    |            {1, 9, 8,    3, 4, 2,   5, 6, 7},
ka
                {8, 5, 9,   7, 6, 1,    4, 2, 3},
                {4, 2, 6,   8, 5, 3,    7, 9, 1},
                {7, 1, 3,   9, 2, 4,    8, 5, 6},

                {9, 6, 1,   5, 3, 7,    2, 8, 4},
                {2, 8, 7,   4, 1, 9,    6, 3, 5},
                {3, 4, 5,   2, 8, 6,    1, 7, 9}
 */