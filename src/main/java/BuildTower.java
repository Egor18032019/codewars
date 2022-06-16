import java.util.Arrays;

public class BuildTower {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(towerBuilder(2)));
    }

    public static String[] towerBuilder(int nFloors) {
        String[] foo = new String[nFloors];

        for (int floor = 0; floor < foo.length; floor++) {

            int sumOnFloor = (nFloors - 1) * 2 + 1;
            StringBuilder bar = new StringBuilder(sumOnFloor);
            int blockOnFloor = (floor + 1) * 2 - 1;
            int emptyOnFloor = sumOnFloor - blockOnFloor; // сколько пустых

            for (int i = 0; i < emptyOnFloor / 2; i++) {
                bar.append(" ");
            }
            int blocks = sumOnFloor - emptyOnFloor;
            for (int i = 0; i < blocks; i++) {
                bar.append("*");
            }
            for (int i = 0; i < emptyOnFloor / 2; i++) {
                bar.append(" ");
            }
            foo[floor] = String.valueOf(bar);
        }

        return foo;
    }
}
/*
Build Tower

Build a pyramid-shaped tower given a positive integer number of floors. A tower block is represented with "*" character.

For example, a tower with 3 floors looks like this:

[
  "  *  ",
  " *** ",
  "*****"
]

And a tower with 6 floors looks like this:

[
  "     *     ",
  "    ***    ",
  "   *****   ",
  "  *******  ",
  " ********* ",
  "***********"
]

 */