import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumerals {

    public static String toRoman(int n) {
        return "I";
    }

    public static int fromRoman(String romanNumeral) {
        return toArabic(romanNumeral);
    }

    private static int toArabic(String romaNum) {
        int result = 0; // Возвращенный результат

        Map<String, Integer> hundredsMap = new HashMap<String, Integer>(); // стобитная карта
        Map<String, Integer> tensMap = new HashMap<String, Integer>(); // Десятибитная карта
        Map<String, Integer> bitsMap = new HashMap<String, Integer>(); // Однобитовая карта

        String[] str1 = "C=100,CC=200,CCC=300,CD=400,D=500,DC=600,DCC=700,DCCC=800,CM=900".split(",");
        for (String split : str1) {
            String[] pair = split.split("=");
            hundredsMap.put(pair[0], Integer.parseInt(pair[1]));
        }

        String[] str2 = "X=10,XX=20,XXX=30,XL=40,L=50,LX=60,LXX=70,LXXX=80,XC=90".split(",");
        for (String split : str2) {
            String[] pair = split.split("=");
            tensMap.put(pair[0], Integer.parseInt(pair[1]));
        }

        String[] str3 = "I=1,II=2,III=3,IV=4,V=5,VI=6,VII=7,VIII=8,IX=9".split(",");
        for (String split : str3) {
            String[] pair = split.split("=");
            bitsMap.put(pair[0], Integer.parseInt(pair[1]));
        }

        Pattern thousandsPattern = Pattern.compile("^M{0,3}");
        Pattern hundredsPattern = Pattern.compile("CM|CD|D?C{0,3}");
        Pattern tensPattern = Pattern.compile("XC|XL|L?X{0,3}");
        Pattern bitsPattern = Pattern.compile("IX|IV|V?I{0,3}$");

        Matcher match1 = thousandsPattern.matcher(romaNum);
        match1.find();
        if (!match1.group().equals("")) // Количество тысяч тысяч соответствует 1000
            result = match1.group().length() * 1000;

        /*
         * Следующие сто цифр, десять цифр и одна цифра сопоставляются согласно их
         * соответствующим картам. Если есть, добавьте соответствующее значение
         */
        Matcher match2 = hundredsPattern.matcher(romaNum.substring(match1.end()));
        match2.find();
        if (!match2.group().equals(""))
            result = result + hundredsMap.get(match2.group());

        Matcher match3 = tensPattern.matcher(romaNum.substring(match2.end() + match1.end()));
        match3.find();

        if (!match3.group().equals("")) {
            result = result + tensMap.get(match3.group());
        }
        Matcher match4 = bitsPattern.matcher(romaNum.substring(match2.end() + match1.end() + match3.end()));
        match4.find();
        if (!match4.group().equals(""))
            result = result + bitsMap.get(match4.group());

        return result;
    }

    private static StringBuilder toFromRoman(int numbeer) {

        StringBuilder result = new StringBuilder(); // Возвращенный результат

        Map<Integer,String > hundredsMap = new HashMap<Integer, String>(); // стобитная карта
        Map<Integer, String> tensMap = new HashMap<Integer, String>(); // Десятибитная карта
        Map<Integer, String> bitsMap = new HashMap<Integer, String>(); // Однобитовая карта

        String[] str1 = "C=100,CC=200,CCC=300,CD=400,D=500,DC=600,DCC=700,DCCC=800,CM=900".split(",");
        for (String split : str1) {
            String[] pair = split.split("=");
            hundredsMap.put(Integer.parseInt(pair[1]), pair[0]);
        }

        String[] str2 = "X=10,XX=20,XXX=30,XL=40,L=50,LX=60,LXX=70,LXXX=80,XC=90".split(",");
        for (String split : str2) {
            String[] pair = split.split("=");
            tensMap.put(Integer.parseInt(pair[1]), pair[0]);
        }

        String[] str3 = "I=1,II=2,III=3,IV=4,V=5,VI=6,VII=7,VIII=8,IX=9".split(",");
        for (String split : str3) {
            String[] pair = split.split("=");
            bitsMap.put(Integer.parseInt(pair[1]), pair[0]);
        }

// разложить числа на составляющие
// добавить гит игнорёЁ

        return result;
    }
}