import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SupermarketQueue {
    public static void main(String[] args) {
        int[] customers = {2,12};
        int kassi = 3;

        System.out.println("answer " + solveSuperMarketQueue(customers, kassi));


    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (customers.length == 0 || n <= 0) {
            return 0;
        }

        List<Integer> arr = new ArrayList<>();
        List<Integer> cos = Arrays.stream(customers).boxed().collect(Collectors.toList());
// 0 1
        boolean isLengthArrMoreThanN = cos.size() >= n;
        if (isLengthArrMoreThanN) {
            for (int i = 0; i < n; i++) {
                arr.add(i, cos.get(i));
            }
            for (int i = 0; i < n; i++) {
                cos.remove(0);
            }
        } else {
            System.out.println("?");
            return Collections.max(cos);
        }


        return rec(arr, cos);
    }

    public static int giveMeIndexForMinElemenetInList(List<Integer> foo) {
        int max = Collections.min(foo);
        int index = foo.indexOf(max);
        return index;
    }

    public static int rec(List<Integer> array, List<Integer> cos) {

        System.out.println(array.toString());
        System.out.println(cos.toString());
        if (cos.size() > 0) {
            int first = giveMeIndexForMinElemenetInList(array);
            System.out.println("first " + first);
            int current = array.get(first);
            int sum = current + cos.get(0);
            array.set(first, sum);
            cos.remove(0);

        }

        if (cos.size() > 0) {
            return rec(array, cos);
        } else {
            return Collections.max(array);
        }

    }
}
/*
    В супермаркете
    очередь к
    кассам самообслуживания.Ваша задача — написать функцию для расчета общего времени,необходимого всем покупателям для оформления заказа!
        вход

        клиенты:
        массив положительных целых чисел,представляющих очередь.
        Каждое целое число представляет покупателя,а его значение — количество времени,которое ему требуется для оформления заказа.
        n:положительное целое число,количество касс.

        выход

        Функция должна возвращать целое число — общее требуемое время.
        Важный

        Пожалуйста,ознакомьтесь с примерами и пояснениями ниже,чтобы убедиться,что вы правильно поняли задачу:)
        Примеры

        время очереди([5,3,4],1)
// должно вернуть 12
// потому что, когда есть 1 касса, общее время равно сумме времен

        время очереди([10,2,3,3],2)
// должно вернуть 10
// потому что здесь n=2 и 2-й, 3-й и 4-й люди в
// очередь заканчивается до того, как закончит 1-й человек.

        время очереди([2,3,10],2)
// должно вернуть 12

        Уточнения

        Существует только ОДНА очередь,обслуживающая множество касс,и
        Порядок очереди НИКОГДА не меняется,и
        Первый человек в очереди(то есть первый элемент в массиве/списке)переходит к кассе,как только она освобождается.

        Н.Б.Вы должны предположить,что все входные данные теста будут действительными,как указано выше.

        P.S.Ситуацию в этом ката можно сравнить с идеей пула потоков,более связанной с информатикой,
        в отношении одновременного запуска нескольких процессов:https://en.wikipedia.org/wiki/Thread_pool
 */