//import java.util.Map;
//
//public class Dinglemouse {
//    Отложил
//    static final String MOVE_UP = "UP";
//    static final String MOVE_RIGHT = "RIGHT";
//    static final String MOVE_LEFT = "LEFT";
//    static final String MOVE_DOWN = "DOWN";
//    static final char EMPTY = ' ';
//    static final char STAR_END = 'X';
//
//    public static void main(String[] args) {
//
//        String[] test = new String[]{
//                "           ",
//                "X---------X",
//                "           ",
//                "           "
//        };
//        int width = test[0].length();
//        int height = test.length;
//
//        char[][] grid = new char[height][width];
//        int i = 0;
//        for (String s : test) {
//            char[] foo = s.toCharArray();
//            grid[i] = foo;
//            i++;
//            //  а если тут идти и проверять что бы например в округе от этого элемента
////            не было не правильных символов ?
//        }
//        System.out.println(line(grid));
//
//    }
//
//    public static boolean line(final char[][] grid) {
//        int gorizont = grid[0].length;
//        int vertical = grid.length;
//        String lastMove = "";
//        boolean isGood = true;
//        for (int v = 0; v < vertical; v++) {
//            for (int g = 0; g < gorizont; g++) {
//                char point = grid[v][g];
//                if (point == 'X') {
//                    isGood = checkLine(grid, v, g, lastMove, vertical, gorizont;
//                }
//
//            }
//        }
//        return isGood;
//    }
//
//    static boolean checkLine(final char[][] grid, int y, int x, String lastMove, int maxV, int maxG) {
//        boolean isGood = true;
//        char right = x < maxG - 1 ? grid[y][x + 1] : EMPTY;
//        char left = x > 0 ? grid[y][x - 1] : EMPTY;
//        char top = y > 0 ? grid[y - 1][x] : EMPTY;
//        char bottom = y < maxV - 1 ? grid[y + 1][x] : EMPTY;
//        char current = grid[y][x];
//        if (lastMove.isEmpty()) {
//
//            if (right == '-' || right == '+') {
//                lastMove = MOVE_RIGHT;
//                x++;
//                return checkLine(grid, y, x, lastMove, maxV, maxG);
//            }
//            if (left == '-' || left == '+') {
//                lastMove = MOVE_RIGHT;
//                x--;
//                return checkLine(grid, y, x, lastMove, maxV, maxG);
//            }
//            if (top == '|' || top == '+') {
//                lastMove = MOVE_UP;
//                y--;
//                return checkLine(grid, y, x, lastMove, maxV, maxG);
//            }
//            if (bottom == '|' || bottom == '+') {
//                lastMove = MOVE_DOWN;
//                y++;
//                return checkLine(grid, y, x, lastMove, maxV, maxG);
//            }
//
//        } else {
//            // 0 1 MoveRigth
//            if (current == '-' || lastMove.equals(MOVE_RIGHT)) {
//                if (right == '-') {
//                    x++;
//                    return checkLine(grid, y, x, lastMove, maxV, maxG);
//                }
//                if (right == '+') {
//                    if (top == '|') {
//                        y--;
//                        lastMove = MOVE_UP;
//                        return checkLine(grid, y, x, lastMove, maxV, maxG);
//                    }
//                    if()
//                }
//            }
//        }
//
////
//        return isGood;
//    }
//
//
//}
//
///*
//
//    "           ",
//    "X---------X",
//    "           ",
//    "           "
//
// */