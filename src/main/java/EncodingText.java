import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EncodingText {
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() throws UnsupportedEncodingException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void close() throws IOException {
        bufferedReader.close();
    }


    public static String codeString(String line) throws Exception {
        String[] charsets = new String[]{"CP866", "CP1251", "KOI8-R", "ISO-8859-5", "UTF-8"};
//        String probe = StandardCharsets.UTF_8.name();
        String code = "UTF-8";
        for (String c : charsets) {
            if (isRightEncode(line, c)) {
                code = c;
            }
        }

        /*
        CP866(DOS)
        CP1251 (Windows)
        KOI8-R
        ISO-8859-5
        CP10007(MacOS)
*/
        return code;
    }

    private static void run() throws Exception {
//        System.out.println("code " + code);
        int i = 0;
        byte[] data = new byte[i];
        Scanner reader = new Scanner(System.in,"ISO-8859-5");
        System.out.println(reader.nextLine());
        String[] charsets = new String[]{"CP866", "CP1251", "KOI8-R", "ISO-8859-5", "UTF-8"};

//        while (i != 10) {
//            byte iter = reader.nextByte();
//            data[i] = iter;
//        }

//        String code = getEncoding(line);
//        System.out.println("code");
//        System.out.println(code);
////            new String(str.getBytes(encode), encode)

         String stroke = new String(data, "CP866");
        System.out.println("stroke");
        System.out.println(stroke);

    }

    public static boolean isRightEncode(String value, String charset) throws UnsupportedEncodingException {
        String foo = new String(value.getBytes(charset), charset);
        return value.equals(foo);
    }


    public static String getEncoding(String str) {

        String encode = "CP866";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        encode = "CP1251";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }

        encode = "KOI8-R";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        encode = "ISO-8859-5";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "UTF-8";
    }

}
