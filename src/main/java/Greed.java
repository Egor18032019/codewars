import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Greed {

    public static void main(String[] args) {
        int[] qwe = {5, 1, 3, 4, 1}; // 250
        int[] asd = {1, 1, 1, 3, 1}; // 1100
        int[] zxc = {2, 4, 4, 5, 4}; // 450
        System.out.println(greedy(zxc));
    }

    public static int greedy(int[] dice) {
        //code here
        Map<Integer, Integer> oneRules = new HashMap<>();
        oneRules.put(1, 100);
        oneRules.put(5, 50);

        Map<Integer, Integer> threeRules = new HashMap<>();
        threeRules.put(1, 1000);
        threeRules.put(6, 600);
        threeRules.put(5, 500);
        threeRules.put(4, 400);
        threeRules.put(3, 300);
        threeRules.put(2, 200);
        int answer = 0;
        List<Integer> prevNumber = new ArrayList<>();
//        int[] qwe = {5, 1, 3, 4, 1}; // 250
//        int[] asd = {1, 1, 1, 3, 1}; // 1100
//        int[] zxc = {2, 4, 4, 5, 4}; // 450
        for (int it : dice) {
            int counter = 0;
            if (!prevNumber.contains(it)) {
                for (int n : dice) {
                    if (n == it) {
                        counter++;
                    }
                }
            }
            if (counter < 3) {
                if (oneRules.containsKey(it)) {
                    answer = answer + oneRules.get(it) * counter;
                }
            }

            if (counter == 3) {
                if (threeRules.containsKey(it)) {
                    if (threeRules.containsKey(it)) {
                        answer = answer + threeRules.get(it);
                    }
                }
            }
            if (counter > 3) {
                int foo = counter / 3;
                int ostatok = counter % 3;
                if (threeRules.containsKey(it) && oneRules.containsKey(it)) {
                    answer = answer + threeRules.get(it) * foo + oneRules.get(it) * ostatok;
                } else {
                    if (threeRules.containsKey(it)) {
                        answer = answer + threeRules.get(it) * foo;
                    }
                    if (oneRules.containsKey(it)) {
                        answer = answer + oneRules.get(it) * ostatok;
                    }
                }

            }
            prevNumber.add(it);
        }


        return answer;
    }
}

/*
Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a throw according to these rules. You will always be given an array with five six-sided dice values.

 Three 1's => 1000 points
 Three 6's =>  600 points
 Three 5's =>  500 points
 Three 4's =>  400 points
 Three 3's =>  300 points
 Three 2's =>  200 points
 One   1   =>  100 points
 One   5   =>   50 point

A single die can only be counted once in each roll. For example, a given "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, but not both in the same roll.

Example scoring

 Throw       Score
 ---------   ------------------
 5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
 1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
 2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)

In some languages, it is possible to mutate the input to the function. This is something that you should never do. If you mutate the input, you will not be able to pass all the tests.

 */