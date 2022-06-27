import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SudokuValidator {

    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},

                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},

                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
//        System.out.println(check(sudoku));
        sudoku[0][0]++;
        sudoku[1][1]++;
        sudoku[0][1]--;
        sudoku[1][0]--;

//        System.out.println(check(sudoku));

        sudoku[0][0]--;
        sudoku[1][1]--;
        sudoku[0][1]++;
        sudoku[1][0]++;

        sudoku[4][4] = 0;

        System.out.println(check(sudoku));
    }

    public static boolean check(int[][] sudoku) {
        //do your magic
        int[] ideal = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Можно добавить еще две проверки
        List<Integer> list = Arrays.stream(ideal).boxed().collect(Collectors.toList());
        if (sudoku.length != 9 || sudoku[0].length != 9) {
            return false;
        }
        List<List<Integer>> itog = new ArrayList<>();

        int endRow = 3;
        for (int row = 0; row < 9; row = row + 3) {
            int end = 3;
            for (int stroka = 0; stroka < 9; stroka = stroka + 3) {
                List<Integer> foo = new ArrayList<>();
                for (int v = stroka; v < end; v++) {
                    for (int i = row; i < endRow; i++) {
                        foo.add(sudoku[i][v]);
                    }
                }
                if (!foo.containsAll(list)) {
                    return false;
                }
                itog.add(foo);
                end = end + 3;
            }
            endRow = endRow + 3;
        }

        for (List<Integer> asd : itog) {
            System.out.println(asd);
        }
        return true;
    }

}
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