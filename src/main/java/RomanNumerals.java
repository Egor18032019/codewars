import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumerals {


    static Map<String, Integer> arabicHundredsMap = new HashMap<String, Integer>(); // стобитная карта
    static Map<String, Integer> arabicTensMap = new HashMap<String, Integer>(); // Десятибитная карта
    static Map<String, Integer> arabicBitsMap = new HashMap<String, Integer>(); // Однобитовая карта
    static Map<Integer, String> romanHundredsMap = new HashMap<Integer, String>(); // стобитная карта
    static Map<Integer, String> romanTensMap = new HashMap<Integer, String>(); // Десятибитная карта
    static Map<Integer, String> romanBitsMap = new HashMap<Integer, String>(); // Однобитовая карта

    static {
        System.out.println(" этот первый блок");
        String[] str1 = "C=100,CC=200,CCC=300,CD=400,D=500,DC=600,DCC=700,DCCC=800,CM=900".split(",");
        for (String split : str1) {
            String[] pair = split.split("=");
            arabicHundredsMap.put(pair[0], Integer.parseInt(pair[1]));
            romanHundredsMap.put(Integer.parseInt(pair[1]), pair[0]);
        }

        String[] str2 = "X=10,XX=20,XXX=30,XL=40,L=50,LX=60,LXX=70,LXXX=80,XC=90".split(",");
        for (String split : str2) {
            String[] pair = split.split("=");
            arabicTensMap.put(pair[0], Integer.parseInt(pair[1]));
            romanTensMap.put(Integer.parseInt(pair[1]), pair[0]);
        }

        String[] str3 = "I=1,II=2,III=3,IV=4,V=5,VI=6,VII=7,VIII=8,IX=9".split(",");
        for (String split : str3) {
            String[] pair = split.split("=");
            arabicBitsMap.put(pair[0], Integer.parseInt(pair[1]));
            romanBitsMap.put(Integer.parseInt(pair[1]), pair[0]);
        }
    }

    public static void main(String[] args) {
        System.out.println(RomanNumerals.toRoman(33));
        System.out.println(RomanNumerals.fromRoman("LXXX"));
    }

    public static String toRoman(int n) {
        return toForRoman(n);
    }

    public static int fromRoman(String romanNumeral) {
        return toArabic(romanNumeral);
    }

    private static int toArabic(String romaNum) {
        int result = 0; // Возвращенный результат

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
            result = result + arabicHundredsMap.get(match2.group());

        Matcher match3 = tensPattern.matcher(romaNum.substring(match2.end() + match1.end()));
        match3.find();

        if (!match3.group().equals("")) {
            result = result + arabicTensMap.get(match3.group());
        }
        Matcher match4 = bitsPattern.matcher(romaNum.substring(match2.end() + match1.end() + match3.end()));
        match4.find();
        if (!match4.group().equals(""))
            result = result + arabicBitsMap.get(match4.group());

        return result;
    }

    private static String toForRoman(int number) {
//        1 <= n < 4000
        StringBuilder result = new StringBuilder();
        int thousand = (int) Math.floor(number / 1000);
        if (thousand > 0) {
            for (int i = 0; i < thousand; i++) {
                result
                        .append("M");
            }
        }
        int hundred = (int) Math.floor((number - thousand * 1000) / 100) * 100;
        if(hundred>0){
            result
                    .append(romanHundredsMap.get(hundred));
        }
        int tens = (int) Math.floor((number - thousand * 1000 - hundred) / 10) * 10;
        if(tens>0){
            result
                    .append(romanTensMap.get(tens));
        }
        int bit = (int) Math.floor(number - thousand * 1000 - hundred - tens);
        if(bit>0){
            result
                    .append(romanBitsMap.get(bit));
        }


        return String.valueOf(result);
    }
}