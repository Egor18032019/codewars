import java.util.ArrayList;
import java.util.List;

public class SumOfSquares {

    public static void main(String[] args) {
        System.out.println(nSquaresFor(15));
    }

    public static int nSquaresFor(int n) {
        System.out.println(n);
        List<Integer> sum = new ArrayList<>();
        giveMeSqrt(n, sum);
        // ха ха 18 = 9*2 + 9*2 и 36 также
        return sum.size();
    }

    public static void giveMeSqrt(int n, List<Integer> sum) {
//        If(n==0)
        int foo = n / 2;
        int bar = (int) Math.sqrt(foo);
        int firstDiff = n - (bar * bar * 2);
        if (firstDiff <= 1 && foo != 0) {
            sum.add(bar);
            sum.add(bar);
            if (firstDiff != 0) {
                giveMeSqrt(firstDiff, sum);
            }
        } else {

            int first = (int) Math.sqrt(n);
            if (first == 1) {
                sum.add(first);
                int diff = n - first * first;
                if (diff > 0) {
                    giveMeSqrt(diff, sum);
                }
            }

            if (first >= 2) {
                sum.add(first);
                int diff = n - first * first;
                if (diff > 0) {
                    giveMeSqrt(diff, sum);
                }
            }
        }
    }
}
