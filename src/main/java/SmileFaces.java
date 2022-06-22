import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SmileFaces {
    public static void main(String[] args) {
        String[] sml = {":)", ";(", ";}", ":-D" }; //2
        String[] sml1 = {";D", ":-(", ":-)", ";~)" }; //3
        String[] sml2 = {";]", ":[", ";*", ":$", ";-D" }; // 1
        String[] sml3 = {":)", ":D", ":-}", ":-()" }; // 2
//        System.out.println(countSmileys(Arrays.stream(sml).collect(Collectors.toList())));
//        System.out.println(countSmileys(Arrays.stream(sml1).collect(Collectors.toList())));
//        System.out.println(countSmileys(Arrays.stream(sml2).collect(Collectors.toList())));
        System.out.println(countSmileys(Arrays.stream(sml3).collect(Collectors.toList())));

    }

    public static int countSmileys(List<String> arr) {
        int count = 0;
        for (String smile : arr) {
            if (smile.length() > 3 || smile.length() < 2) {
                continue;
            }
            boolean isFirstEyes = smile.startsWith(":") || smile.startsWith(";");
            boolean isLastMouth = smile.endsWith(")") || smile.endsWith("D");
            boolean isRightNose = true;
//            System.out.println(smile.length());
            if (smile.length() == 2) {
                isRightNose = true;
            }

            if (smile.length() == 3) {
                isRightNose = smile.startsWith("-", 1) || smile.startsWith("~", 1);
            }
//            System.out.println("isFirstEyes - " + isFirstEyes + ", isLastMouth - " + isLastMouth + ", isRightNose - " + isRightNose);
            boolean isCount = isFirstEyes && isLastMouth && isRightNose;
//            System.out.println(isCount);
            if (isCount) {
                count++;
            }
        }
        // Just Smile :)
        return count;
    }
}
/*
Каждый смайлик должен содержать допустимую пару глаз. Глаза могут быть отмечены как : или ;
У смайлика может быть нос, но не обязательно. Допустимые символы для носа - или ~
Каждое улыбающееся лицо должно иметь улыбающийся рот, который должен быть отмечен знаком ) или D.
 */