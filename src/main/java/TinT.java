import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TinT {
    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();

    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        final int days = Integer.parseInt(reader.readLine().trim());

        String[] line = reader.readLine().trim().split(" ");
        int oddLength = line.length / 2;
        int[] oddArr = new int[oddLength];
        int[] evenArr = new int[line.length - oddLength];
        int oddCount = 0;
        int evenCount = 0;
        for (int i = 1; i <= line.length; i++) {
            if (i % 2 == 0) {
                oddArr[oddCount] = Integer.parseInt(line[i - 1]);
                oddCount++;
            } else {
                evenArr[evenCount] = Integer.parseInt(line[i - 1]);
                evenCount++;
            }
        }

        // найти сумму всех элементом
        // где больше сумма от туда взять меньшее число и а во втором взять большее сравнить и поменять
        int sumOdd =  giveSum(oddArr);
        int sumEven =  giveSum(evenArr);
        Arrays.sort(oddArr);
        Arrays.sort(evenArr);


        if (sumEven > sumOdd) {
            int minEven = evenArr[0];
            int maxOdd = oddArr[oddLength - 1];
            evenArr[0] = maxOdd;
            oddArr[oddLength - 1] = minEven;

        } else {
            int minOdd = oddArr[0];
            int maxEven = evenArr[oddLength - 1];
            oddArr[0] = minOdd;
            evenArr[oddLength - 1] = maxEven;
        }
        int sumOdd1 = giveSum(oddArr);
        int sumEven1 = giveSum(evenArr);
        System.out.println(sumEven1 - sumOdd1);
    }

    public static int giveSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            // суммирование каждого элемента массива
            sum = sum + num;
        }
        return sum;
    }
}
/*
Во время анализа данных ваш знакомый задался вопросом,
 увеличилась бы прибыль компании,
  если бы данные за какие-то дни поменялись местами.
В качестве первого этапа он решил поменять местами не более двух дней.
---- то есть два числа только ?
 */