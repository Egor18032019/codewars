public class test {

    public static void main(String[] args) {

    }

    public String equation(long a, long b, long c) {
//a*x*x+b*x+c = 7.
        if (a == 0) {
            int x = (int) ((7 - c) / b);
            return "x = " + x;
        }
//        a*x*x+b*x+c-7 = 0.
        long rightC = c - 7;
        if (b == 0 && rightC == 0) return "X = 0";
        if (b == 0 && rightC != 0) {
            if (-(c / a) > 0) {
                // Два корня
                int value = (int) Math.sqrt(-rightC / a);
                return "Два действительных корня решения это +-" + value;
            } else {
                int value = (int) Math.sqrt(-rightC / a);
                // Один
                return "Один действительный корень решения = " + value;
            }
        }
        if (b != 0 && rightC == 0) {
            int value_1 = 0;
            int value_2 = Math.toIntExact(-b / a);
            return " Два ответа x1 = " + value_1 + " x2 = " + value_2;
        }

        return "No have answer";
    }


}

/*
Дано уравнение вида a*x*x+b*x+c = 7.
Необходимо написать метод, который принимает на вход целочисленные значения коэффициентов a,b,c
 и возвращает решение уравнения относительно Х в виде строки.
 */