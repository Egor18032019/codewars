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

/*

 */