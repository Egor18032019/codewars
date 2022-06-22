import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnailSort {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(Arrays.toString(snail(array)));
    }

    public static int[] snail(int[][] array) {
        // enjoy
        int width = array[0].length;
        int height = array.length;
        int answerLength = width * height;
        int[] answer = new int[answerLength];
        int right = -1;
        int arrWidth = width - 1;
        int arrHeight = height - 1;
        int down = 0;
        int count = 0;
        int leftWidth = -1;
        int upHeigth = 0;
         /*
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
         */
        while (count < answerLength) {
            // идем в право
            if (down == upHeigth && count < answerLength) { // если дошли до верха
//                arrHeight--;
                while (right < arrWidth) {
                    right++;
                    answer[count] = array[down][right];
                    count++;
                }
                leftWidth++;
            }
            // идем в низ
            if (right == arrWidth && count < answerLength) { // если дошло до правого края
//                a
                while (down < arrHeight) {
                    down++;
                    answer[count] = array[down][right];
                    count++;
                }
                upHeigth++;
            }
            if (down == arrHeight && count < answerLength) { // если дошло до низа
//                upHeigth++;
                while (right > leftWidth) {
                    right--;
                    answer[count] = array[down][right];
                    count++;
                }
                arrWidth--;
            }

            if (right == leftWidth && count < answerLength) { // если дошло до левого края
//                leftWidth++;
                while (down > upHeigth) {
                    down--;
                    answer[count] = array[down][right];
                    count++;
                }
                arrHeight--;
            }
        }

        return answer;
    }
}
