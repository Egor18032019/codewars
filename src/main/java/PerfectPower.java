public class PerfectPower {
    public static void main(String[] args) {

    }

    public static int[] isPerfectPower(int n) {
        int[] arr = new int[2];
        for (int i = 2; i < n; i++) {

            if (Math.pow(i, 2)> n ) {
                break;
            }
            for (int j = 2; j < Math.sqrt(n)+1; j++) {
                if (Math.pow(i, j) == n) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
                if (Math.pow(i, j) > n) {
                    break;
                }
            }

        }
        return null;
    }
    }


