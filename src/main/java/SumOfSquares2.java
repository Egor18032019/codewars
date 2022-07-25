import java.util.ArrayList;
import java.util.List;

public class SumOfSquares2 {
    // первый вариант не корректно работает
    public static void main(String[] args) {
        System.out.println(nSquaresFor(15));
        // 661915703 => 4 а не 6
    }

    public static int nSquaresFor(int n) {
        System.out.println(n);
        if (n == 0) return 0;
        if (n == 1) return 1;
        double d = Math.sqrt(n);
        int maxSqrr = (int) d;
        int minSums = n; // ну меньше же точно не будет.
//        System.out.println(maxSqrr);
        // ставим ограничение maxSqrr максимальный корень
        for (int i = 1; i <= maxSqrr; i++) {
            // и далее с начиная с 1 и до максимального корня
            // рассматриваем все варианты

            int newSqrtForItterator = i * i; //4

            int firstDiff = n - newSqrtForItterator; //20 -4 =16

            int count = 1;

            while (newSqrtForItterator != n) {
                int sqrt = (int) Math.sqrt(firstDiff); //4

                int sum = newSqrtForItterator + sqrt * sqrt; //4 + 16
                firstDiff = n - sum; // 20 -20 = 0
                count++;
            }

            // и выставляем минимальную
            if (minSums > count) minSums = count;

        }

        return minSums;
    }
}
/*


 */