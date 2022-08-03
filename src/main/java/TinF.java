import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinF {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String firstLine = reader.readLine();

        final String sekondLine = reader.readLine();
        String[] first = firstLine.split(" ");
        String[] sekond = sekondLine.split(" ");
        // 0 , 1, 2, 3
        int y1 = Math.min(Integer.parseInt(sekond[1]), Math.min(Integer.parseInt(sekond[3]),
                Math.min(Integer.parseInt(first[1]), Integer.parseInt(first[3]))));
        int y2 = Math.max(Integer.parseInt(sekond[1]), Math.max(Integer.parseInt(sekond[3]),
                Math.max(Integer.parseInt(first[1]), Integer.parseInt(first[3]))));
        int x1 = Math.min(Integer.parseInt(sekond[0]), Math.min(Integer.parseInt(sekond[2]),
                Math.min(Integer.parseInt(first[0]), Integer.parseInt(first[2]))));
        int x2 = Math.max(Integer.parseInt(sekond[0]), Math.max(Integer.parseInt(sekond[2]),
                Math.max(Integer.parseInt(first[0]), Integer.parseInt(first[2]))));
        int result = 0;
        if ((x2 - x1) > (y2 - y1)) {
            result = (x2 - x1) * (x2 - x1);
        } else {
            result = (y2 - y1) * (y2 - y1);
        }
        System.out.println(result);
    }
}