import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tin8 {
    private static BufferedReader reader = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
    }

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void run() throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        final int count = Integer.parseInt(firstLine[0]);
        final int buyers = Integer.parseInt(firstLine[1]);
        String[] store = new String[count];
        for (int i = 0; i < count; i++) {
            String value = reader.readLine().trim();
            store[i] = value;
        }


        for (int i = 0; i < buyers; i++) {
            String[] request = reader.readLine().trim().split(" ");

            String first = request[0];
            String last = request[request.length - 1];
            int countFromStore = 0;
            for (int w = 0; w < count; w++) {
                String point = store[w];

                boolean isFirst = point.startsWith(first);
                boolean isLast = point.endsWith(last);
                if (isFirst && isLast) {
                    countFromStore++;
                }

            }
            System.out.println(countFromStore);
        }
        reader.close();


    }
}
