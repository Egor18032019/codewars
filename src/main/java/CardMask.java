
public class CardMask {
    public static void main(String[] args) {
        String str = "01234";
        System.out.println(maskify(str));
    }

    public static String maskify(String str) {
        StringBuilder answer = new StringBuilder();
        boolean isLengthSmall = str.trim().length() < 4;
        if (isLengthSmall) {
            return str;
        }
        int mask = str.trim().length() - 4;
        for (int i = 0; i < mask; i++) {
            answer.append("#");
        }
        answer.append(str.substring(mask));
        return String.valueOf(answer);
    }
}

