import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattleField {


    public static void main(String[] args) {
        int[][] battleField =
                {
                        {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                        {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(fieldValidator(battleField));
    }

    public static boolean fieldValidator(int[][] field) {
//        System.out.println(Arrays.deepToString(field));
        int[] countShips = {1, 2, 3, 4};
        for (int gorizont = 0; gorizont < 10; gorizont++) {
            for (int vertical = 0; vertical < 10; vertical++) {
                if (field[vertical][gorizont] == 1) {
                    List<Integer> ship = new ArrayList<>();
                    ship.add(1);
                    boolean isOk = checkShip(field, gorizont, vertical, ship, countShips);
                    if (ship.size() == 4) {
                        countShips[0] = countShips[0] - 1;
                        if (countShips[0] < 0) return false;
                    }
                    if (ship.size() == 3) {
                        countShips[1] = countShips[1] - 1;
                        if (countShips[1] < 0) return false;
                    }
                    if (ship.size() == 2) {
                        countShips[2] = countShips[2] - 1;
                        if (countShips[2] < 0) return false;
                    }
                    if (ship.size() == 1) {
                        countShips[3] = countShips[3] - 1;
                        if (countShips[3] < 0) return false;
                    }
                    if (!isOk) return false;
                }
            }
        }
        return countShips[0] == 0 && countShips[1] == 0 && countShips[2] == 0 && countShips[3] == 0;
    }

    static boolean checkLine(int[][] field, int gorizont, int vertical, int[] countShips) {
        if (gorizont != 0 && vertical != 0 && vertical != 9 && gorizont != 9) {
            int diagonal1 = field[vertical - 1][gorizont - 1];
            if (diagonal1 == 1) return false;
            int diagonal2 = field[vertical - 1][gorizont + 1];
            if (diagonal2 == 1) return false;
            int diagonal3 = field[vertical + 1][gorizont - 1];
            if (diagonal3 == 1) return false;
            int diagonal4 = field[vertical + 1][gorizont + 1];
            if (diagonal4 == 1) return false;
        }
        boolean isUpperLeftCorner = gorizont == 0 && vertical == 0;
        if (isUpperLeftCorner) {
            int diagonal4 = field[vertical + 1][gorizont + 1];
            if (diagonal4 == 1) return false;
        }
        boolean isDownRightCorner = gorizont == 9 && vertical == 9;
        if (isDownRightCorner) {
            int diagonal1 = field[vertical - 1][gorizont - 1];
            if (diagonal1 == 1) return false;
        }
        boolean isUpperRightCorner = gorizont == 9 && vertical == 0;
        if (isUpperRightCorner) {
            int diagonal3 = field[vertical + 1][gorizont - 1];
            if (diagonal3 == 1) return false;
        }
        boolean isDownLeftCorner = gorizont == 0 && vertical == 9;
        if (isDownLeftCorner) {
            int diagonal2 = field[vertical - 1][gorizont + 1];
            if (diagonal2 == 1) return false;
        }
        if (gorizont == 0 && vertical != 0 && vertical != 9) {
            int diagonal2 = field[vertical - 1][gorizont + 1];
            if (diagonal2 == 1) return false;
            int diagonal4 = field[vertical + 1][gorizont + 1];
            if (diagonal4 == 1) return false;
        }
        if (vertical == 0 && gorizont != 0 && gorizont != 9) {
            int diagonal3 = field[vertical + 1][gorizont - 1];
            if (diagonal3 == 1) return false;
            int diagonal4 = field[vertical + 1][gorizont + 1];
            if (diagonal4 == 1) return false;
        }
        if (vertical == 9 && gorizont != 0 && gorizont != 9) {
            int diagonal1 = field[vertical - 1][gorizont - 1];
            if (diagonal1 == 1) return false;
            int diagonal2 = field[vertical - 1][gorizont + 1];
            if (diagonal2 == 1) return false;
        }
        if (gorizont == 9 && vertical != 0 && vertical != 9) {
            int diagonal1 = field[vertical - 1][gorizont - 1];
            if (diagonal1 == 1) return false;
            int diagonal3 = field[vertical + 1][gorizont - 1];
            if (diagonal3 == 1) return false;
        }

        return true;
    }

    static boolean checkShip(int[][] field,
                             int gorizont, int vertical, List<Integer> ship, int[] countShips) {
        int nextG = gorizont + 1;
        int nextV = vertical + 1;
        boolean isOk = checkLine(field, gorizont, vertical, countShips);
        if (!isOk) return false;
        if (nextG < 10) {
            if (field[vertical][nextG] == 1) {
                field[vertical][nextG] = 0;
                ship.add(1);
                isOk = checkShip(field, nextG, vertical, ship, countShips);
                if (!isOk) return false;
            }
        }

        if (nextV < 10) {
            if (field[nextV][gorizont] == 1) {
                ship.add(1);
                field[nextV][gorizont] = 0;
                isOk = checkShip(field, gorizont, nextV, ship, countShips);
                if (!isOk) return false;
            }
        }

        return true;
    }
}
