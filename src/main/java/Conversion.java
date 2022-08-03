import java.util.HashMap;
import java.util.Map;

public class Conversion {

    static Map<Integer, String> romanHundredsMap = new HashMap<Integer, String>(); // стобитная карта
    static Map<Integer, String> romanTensMap = new HashMap<Integer, String>(); // Десятибитная карта
    static Map<Integer, String> romanBitsMap = new HashMap<Integer, String>(); // Однобитовая карта

    static {
        System.out.println(" этот первый блок");
        String[] str1 = "C=100,CC=200,CCC=300,CD=400,D=500,DC=600,DCC=700,DCCC=800,CM=900".split(",");
        for (String split : str1) {
            String[] pair = split.split("=");
            romanHundredsMap.put(Integer.parseInt(pair[1]), pair[0]);
        }

        String[] str2 = "X=10,XX=20,XXX=30,XL=40,L=50,LX=60,LXX=70,LXXX=80,XC=90".split(",");
        for (String split : str2) {
            String[] pair = split.split("=");
            romanTensMap.put(Integer.parseInt(pair[1]), pair[0]);
        }

        String[] str3 = "I=1,II=2,III=3,IV=4,V=5,VI=6,VII=7,VIII=8,IX=9".split(",");
        for (String split : str3) {
            String[] pair = split.split("=");
            romanBitsMap.put(Integer.parseInt(pair[1]), pair[0]);
        }
    }

    public String solution(int n) {
        return toForRoman(n);
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
