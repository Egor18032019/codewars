public class ExexAndOhs {

    public static void main(String[] args) {
        System.out.println(getXO(" "));
    }

    public static boolean getXO(String str) {

        String[] foo = str.trim().split("");
        int x = 0;
        int y = 0;
        for (int i = 0; i < foo.length; i++) {
            if (foo[i].toLowerCase().equals("x")) x++;
            if (foo[i].toLowerCase().equals("o")) y++;
        }

        return x==y;
    }
    public static boolean getXOBest (String str) {
        str = str.toLowerCase();
        return str.replace("o","").length() == str.replace("x","").length();

    }
}
/*
Check to see if a string has the same amount of 'x's and 'o's. The method must return a boolean and be case insensitive. The string can contain any char.

Examples input/output:

XO("ooxx") => true
XO("xooxx") => false
XO("ooxXm") => true
XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
XO("zzoo") => false


"([{}])"
"([{})]"

 */