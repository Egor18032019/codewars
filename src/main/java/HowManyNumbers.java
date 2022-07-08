import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HowManyNumbers {
    public static void main(String[] args) {
        System.out.println(findAll(35, 6));
    }


    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        // Your code here!!

        List<Long> answer = new ArrayList<>();
        if (sumDigits > numDigits * 9) return answer;
        if (sumDigits == 1 && numDigits > 1) return answer;


        int firstNumber = 1;
        while (firstNumber <= 9) {

                answer.addAll(giveMePoint(sumDigits, numDigits, firstNumber));

            firstNumber++;


        }
        answer = answer.stream().filter(
                Objects::nonNull
        ).collect(Collectors.toList());

        System.out.println(answer);
        Long min = answer.get(0);
        Long max = answer.get((answer.size() - 1));
        List<Long> myAnswer = new ArrayList<>();
        myAnswer.add((long) answer.size());
        myAnswer.add(min);
        myAnswer.add(max);
        return myAnswer;
    }

    public static Long giveMeDigitsLongForArr(List<Integer> arr, final int numDigits) {
        if (arr.size() < numDigits) return null;
        int answer = 0;
        int factor = 1;
        for (int i = arr.size() - 1; i >= 0; i--) {
            int cell = arr.get(i);
            answer = answer + cell * factor;
            factor = factor * 10;
        }
        return (long) answer;
    }

    public static List<Long> giveMePoint(final int sumDigits, final int numDigits,
                                         int firstNumber ) {


        List<Long> answer = new ArrayList<>();
        int length = numDigits - 1;

        int count = length - 1;

        while (count > 0) {


            int next = firstNumber;
            int lastCount = 9 - next;

            while (lastCount > 0) {
                List<Integer> digits = new ArrayList<>();
                for (int i = 0; i < length-1; i++) {
                    digits.add(firstNumber);
                }
                digits.add(next);
                next++;

                int sumNumbers = digits.stream().mapToInt(a -> a).sum();
                int endNumber = sumDigits - sumNumbers;
                // если 0 добавить
                if (endNumber < 1) {
                    break;
                }
                if (endNumber <= 9) {
                    int prevNumber = digits.get(digits.size() - 1);
                    if (endNumber >= prevNumber) {
                        digits.add(endNumber);
                    }
                }

                answer.add(giveMeDigitsLongForArr(digits, numDigits));
                lastCount--;
            }

            count--;
        }

        return answer;
    }

}
