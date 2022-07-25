import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanRecord {
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void close() throws IOException {
        bufferedReader.close();
    }

    private static void run() throws IOException {
        String firstLine = bufferedReader.readLine().trim();
        int count = Integer.parseInt(firstLine);
        for (int i = 0; i < count; i++) {
            String str = bufferedReader.readLine();
            boolean allGood = isValid(str);
            if (allGood){
            System.out.println(toArabic(str));
            }else{
                System.out.println(-1);
            }
        }
    }


    private static boolean isValid(String romaNum) {
        String matchStr = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        boolean isRoma = romaNum.matches(matchStr);
        return isRoma;
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
         * Следующие сто цифр, десять цифр и одна цифра сопоставляются согласно их соответствующим картам. Если есть, добавьте соответствующее значение
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

}
