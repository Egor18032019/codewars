public class Scramblies {

    public static void main(String[] args) {


//        System.out.println(scramble("rkqodlw", "world"));
//        System.out.println(scramble("cedewaraaossoqqyt", "codewars"));
//        System.out.println(scramble("katas", "steak"));
//        System.out.println(scramble("scriptjavx", "javascript"));
        System.out.println(scramble("scriptingjava", "javascript"));
//        System.out.println(scramble("scriptsjava", "javascripts"));
//        System.out.println(scramble("javscripts", "javascript"));
//        System.out.println(scramble("aabbcamaomsccdd", "commas"));
//        System.out.println(scramble("commas", "commas"));
//        System.out.println(scramble("sammoc", "commas"));
    }

    public static boolean scramble(String str1, String str2) {
        // your code

        String[] arrPortion = str2.split("");
        for (int i = 0; i < arrPortion.length; i++) {
            String foo = arrPortion[i];
            if (!str1.contains(foo)) {
                return false;
            } else {
                str1 =str1.replaceFirst(foo,"1");
            }
        }

        return true;
    }
}
